/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.issues;

import ch.tsphp.common.exceptions.TSPHPException;

/**
 * Represents a logger which logs issues.
 * <p/>
 * A concrete implementation might be one which writes the issues to the console.
 */
public interface IIssueLogger
{
    void log(TSPHPException ex, EIssueSeverity severity);
}
