/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.test.unit.issues;


import ch.tsphp.common.exceptions.UnexpectedTokenException;
import ch.tsphp.tinsphp.common.issues.EIssueSeverity;
import ch.tsphp.tinsphp.common.issues.IIssueLogger;
import ch.tsphp.tinsphp.common.issues.IssueReporterHelper;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class IssueReporterHelperTest
{
    @Test
    public void reportIssue_NoErrorLoggers_doNothing() {
        RecognitionException ex = mock(RecognitionException.class);

        IssueReporterHelper.reportIssue(null, ex, "phase");

        verifyNoMoreInteractions(ex);
    }

    @Test
    public void reportIssue_tokenNull_MessageContainsUnknownToken() {
        RecognitionException ex = mock(RecognitionException.class);
        IIssueLogger issueLogger = mock(IIssueLogger.class);
        Collection<IIssueLogger> issueLoggers = new ArrayList<>();
        issueLoggers.add(issueLogger);

        IssueReporterHelper.reportIssue(issueLoggers, ex, "phase");

        ArgumentCaptor<UnexpectedTokenException> captor = ArgumentCaptor.forClass(UnexpectedTokenException.class);
        verify(issueLogger).log(captor.capture(), eq(EIssueSeverity.FatalError));
        assertThat(captor.getValue().getMessage(), containsString("Unknown token"));
    }


    @Test
    public void reportIssue_tokenNotNull_MessageContainsUnexpectedToken() {
        RecognitionException ex = new RecognitionException();
        ex.token = new CommonToken(1, "token");
        IIssueLogger issueLogger = mock(IIssueLogger.class);
        Collection<IIssueLogger> issueLoggers = new ArrayList<>();
        issueLoggers.add(issueLogger);

        IssueReporterHelper.reportIssue(issueLoggers, ex, "phase");

        ArgumentCaptor<UnexpectedTokenException> captor = ArgumentCaptor.forClass(UnexpectedTokenException.class);
        verify(issueLogger).log(captor.capture(), eq(EIssueSeverity.FatalError));
        assertThat(captor.getValue().getMessage(), containsString("Unexpected token"));
    }

    @Test
    public void hasFound_NoFoundAndLookingForAny_ReturnsFalse() {
        EnumSet<EIssueSeverity> issuesFound = EnumSet.noneOf(EIssueSeverity.class);
        EnumSet<EIssueSeverity> severities = EnumSet.allOf(EIssueSeverity.class);

        boolean result = IssueReporterHelper.hasFound(issuesFound, severities);

        assertThat(result, is(false));
    }

    @Test
    public void hasFound_NoFoundAndLookingForNone_ReturnsFalse() {
        EnumSet<EIssueSeverity> issuesFound = EnumSet.noneOf(EIssueSeverity.class);
        EnumSet<EIssueSeverity> severities = EnumSet.noneOf(EIssueSeverity.class);

        boolean result = IssueReporterHelper.hasFound(issuesFound, severities);

        assertThat(result, is(false));
    }

    @Test
    public void hasFound_FoundFatalAndLookingForAny_ReturnsTrue() {
        EnumSet<EIssueSeverity> issuesFound = EnumSet.of(EIssueSeverity.FatalError);
        EnumSet<EIssueSeverity> severities = EnumSet.allOf(EIssueSeverity.class);

        boolean result = IssueReporterHelper.hasFound(issuesFound, severities);

        assertThat(result, is(true));
    }

    @Test
    public void hasFound_FoundFatalAndLookingForFatal_ReturnsTrue() {
        EnumSet<EIssueSeverity> issuesFound = EnumSet.of(EIssueSeverity.FatalError);
        EnumSet<EIssueSeverity> severities = EnumSet.of(EIssueSeverity.FatalError);

        boolean result = IssueReporterHelper.hasFound(issuesFound, severities);

        assertThat(result, is(true));
    }


    @Test
    public void hasFound_FoundFatalAndLookingForErrorAndFatal_ReturnsTrue() {
        EnumSet<EIssueSeverity> issuesFound = EnumSet.of(EIssueSeverity.FatalError);
        EnumSet<EIssueSeverity> severities = EnumSet.of(EIssueSeverity.FatalError, EIssueSeverity.Error);

        boolean result = IssueReporterHelper.hasFound(issuesFound, severities);

        assertThat(result, is(true));
    }

    @Test
    public void hasFound_FoundFatalAndLookingForError_ReturnsFalse() {
        EnumSet<EIssueSeverity> issuesFound = EnumSet.of(EIssueSeverity.FatalError);
        EnumSet<EIssueSeverity> severities = EnumSet.of(EIssueSeverity.Error);

        boolean result = IssueReporterHelper.hasFound(issuesFound, severities);

        assertThat(result, is(false));
    }

    @Test
    public void hasFound_FoundFatalAndLookingForNone_ReturnsFalse() {
        EnumSet<EIssueSeverity> issuesFound = EnumSet.of(EIssueSeverity.FatalError);
        EnumSet<EIssueSeverity> severities = EnumSet.noneOf(EIssueSeverity.class);

        boolean result = IssueReporterHelper.hasFound(issuesFound, severities);

        assertThat(result, is(false));
    }
}
