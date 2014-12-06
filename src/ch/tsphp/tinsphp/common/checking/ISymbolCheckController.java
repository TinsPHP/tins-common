/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.checking;

import ch.tsphp.common.ITSPHPAst;

/**
 * Coordinates check of symbols such as double definition checks and forward reference usage.
 */
public interface ISymbolCheckController
{
    ForwardReferenceCheckResultDto isNotForwardReference(ITSPHPAst identifier);

    DoubleDefinitionCheckResultDto isNotDoubleDefinition(ITSPHPAst identifier);

    DoubleDefinitionCheckResultDto isNotDoubleDefinitionCaseInsensitive(ITSPHPAst identifier);

    DoubleDefinitionCheckResultDto isNotUseDoubleDefinition(ITSPHPAst alias);

    AlreadyDefinedAsTypeResultDto isNotAlreadyDefinedAsType(ITSPHPAst alias);

    VariableInitialisedResultDto isVariableInitialised(ITSPHPAst variableId);
}
