/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.issues;

/**
 * Provides the issue messages for a provide in a certain language.
 * <p/>
 * This interface is used to abstract internationalisation of the issue messages.
 */
public interface IIssueMessageProvider
{
    String getDefinitionErrorMessage(String identifier, DefinitionIssueDto dto);

    String getReferenceErrorMessage(String identifier, ReferenceIssueDto dto);
}
