/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This file is based on the file ITypeCheckErrorReporter from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.issues;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.exceptions.DefinitionException;
import ch.tsphp.common.exceptions.ReferenceException;
import ch.tsphp.common.symbols.ISymbol;
import ch.tsphp.tinsphp.common.inference.constraints.IBindingCollection;
import ch.tsphp.tinsphp.common.inference.constraints.IConstraint;

/**
 * Represents the type inference engine's issue reporter.
 * <p/>
 * What ever error occurs in the definition, reference or inference phase will be reported using an instance of
 * this interface.
 */
public interface IInferenceIssueReporter extends IIssueReporter
{
    DefinitionException determineAlreadyDefined(ISymbol existingSymbol, ISymbol typeSymbol);

    DefinitionException alreadyDefined(ISymbol existingSymbol, ISymbol newSymbol);

    DefinitionException aliasForwardReference(ITSPHPAst typeAst, ITSPHPAst useDefinition);

    DefinitionException forwardReference(ITSPHPAst definitionAst, ITSPHPAst identifier);

    DefinitionException variablePartiallyInitialised(ITSPHPAst definitionAst, ITSPHPAst variableId);

    DefinitionException variableNotInitialised(ITSPHPAst definitionAst, ITSPHPAst variableId);

    ReferenceException notDefined(ITSPHPAst identifier);

    ReferenceException unknownType(ITSPHPAst typeAst);

    void partialReturnFromFunction(ITSPHPAst identifier);

    void noReturnFromFunction(ITSPHPAst identifier);

    ReferenceException constraintViolation(IBindingCollection bindings, IConstraint constraint);
}
