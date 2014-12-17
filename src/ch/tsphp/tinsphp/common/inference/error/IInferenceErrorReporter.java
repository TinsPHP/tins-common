/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.error;

import ch.tsphp.common.IErrorReporter;
import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.exceptions.DefinitionException;
import ch.tsphp.common.exceptions.ReferenceException;
import ch.tsphp.common.symbols.ISymbol;

/**
 * Represents the type inference engine's error reporter.
 * <p/>
 * What ever error occurs in the definition, reference or inference phase will be reported using an instance of
 * this interface.ant
 */
public interface IInferenceErrorReporter extends IErrorReporter
{
    DefinitionException determineAlreadyDefined(ISymbol existingSymbol, ISymbol typeSymbol);

    DefinitionException alreadyDefined(ISymbol existingSymbol, ISymbol newSymbol);

    DefinitionException aliasForwardReference(ITSPHPAst typeAst, ITSPHPAst useDefinition);

    DefinitionException forwardReference(ITSPHPAst definitionAst, ITSPHPAst identifier);

    DefinitionException variablePartiallyInitialised(ITSPHPAst definitionAst, ITSPHPAst variableId);

    DefinitionException variableNotInitialised(ITSPHPAst definitionAst, ITSPHPAst variableId);

    void partialReturnFromFunction(ITSPHPAst identifier);

    void noReturnFromFunction(ITSPHPAst identifier);

    ReferenceException notDefined(ITSPHPAst identifier);

    ReferenceException unknownType(ITSPHPAst typeAst);
}