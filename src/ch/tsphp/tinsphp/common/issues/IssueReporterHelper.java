/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This class is based on the class ErrorReporterHelper from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.issues;


import ch.tsphp.common.exceptions.UnexpectedTokenException;
import org.antlr.runtime.RecognitionException;

import java.util.Collection;
import java.util.EnumSet;

/**
 * Provides methods which can be used by the AST walkers and parsers.
 */
public final class IssueReporterHelper
{
    private IssueReporterHelper() {
    }

    public static void reportIssue(
            final Collection<IIssueLogger> issueLoggers,
            final RecognitionException exception,
            final String phase) {

        if (issueLoggers != null) {
            final String tokenText = exception.token != null
                    ? "Unexpected token: " + exception.token.getText()
                    : "Unknown token";
            for (IIssueLogger logger : issueLoggers) {
                UnexpectedTokenException ex = new UnexpectedTokenException(
                        "Line " + exception.line + "|" + exception.charPositionInLine
                                + " exception during " + phase + " phase occurred. " + tokenText, exception, phase);
                logger.log(ex, EIssueSeverity.FatalError);
            }
        }
    }

    public static boolean hasFound(EnumSet<EIssueSeverity> issuesFound, EnumSet<EIssueSeverity> lookingForSeverities) {
        boolean hasFound = false;
        if (issuesFound.size() > 0) {
            for (EIssueSeverity severity : lookingForSeverities) {
                hasFound = issuesFound.contains(severity);
                if (hasFound) {
                    break;
                }
            }
        }
        return hasFound;
    }
}
