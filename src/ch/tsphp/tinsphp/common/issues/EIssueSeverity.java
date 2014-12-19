/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.issues;

/**
 * Represents the severity level of an issue.
 */
public enum EIssueSeverity
{
    // type inference or translation cannot proceed, e.g. double defined functions
    FatalError,

    // e.g. a bug, translation can proceed but includes the same bug - for instance,
    // passing a wrong type and no conversion exists
    Error,

    // e.g. superfluous arguments are passed
    Warning,

    // e.g. function does not return in all cases
    Notice,

    // e.g. just some info, only for the user in order that one can set issues as information only and such
    // information is usually only used
    Info,
}