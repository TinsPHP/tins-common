/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.issues;

import java.util.EnumSet;

/**
 * Represents an issue reporter.
 * <p/>
 * The concrete implementation decides what severity an issue has.
 */
public interface IIssueReporter
{
    /**
     * Add the given issue logger as listener for issues.
     * <p/>
     * The issue reporter will pass all issues detected to the registered issue loggers.
     */
    void registerIssueLogger(IIssueLogger logger);

    /**
     * Indicate whether one or more issues where found with one of the given severity levels.
     */
    boolean hasFound(EnumSet<EIssueSeverity> severities);

    /**
     * Drop previous issues
     */
    void reset();
}
