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
    void registerIssueLogger(IIssueLogger logger);

    boolean hasFound(EnumSet<EIssueSeverity> severity);

    void reset();
}
