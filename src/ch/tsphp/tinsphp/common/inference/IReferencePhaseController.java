/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This class is based on the class IReferencePhaseController from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.inference;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.ITSPHPErrorAst;
import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.inference.constraints.IConstraintCollection;
import ch.tsphp.tinsphp.common.symbols.IMethodSymbol;
import ch.tsphp.tinsphp.common.symbols.IMinimalMethodSymbol;
import ch.tsphp.tinsphp.common.symbols.IMinimalVariableSymbol;
import ch.tsphp.tinsphp.common.symbols.IUnionTypeSymbol;
import ch.tsphp.tinsphp.common.symbols.IVariableSymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.IErroneousTypeSymbol;
import org.antlr.runtime.RecognitionException;

import java.util.List;

/**
 * Represents the interface between the TSPHPReferenceWalker (ANTLR generated) and the logic.
 * <p/>
 * It provides methods to resolve symbols, which check that symbols are ready to use as well as methods which create
 * constraints for operations.
 */
public interface IReferencePhaseController
{

    IVariableSymbol resolveConstant(ITSPHPAst identifier);

    //TODO rstoll TINS-223 reference phase - resolve this and self
//    IVariableSymbol resolveThisSelf(ITSPHPAst $this);

    //TODO rstoll TINS-225 reference phase - resolve parent
//    IVariableSymbol resolveParent(ITSPHPAst $this);

    IVariableSymbol resolveVariable(ITSPHPAst variableId);

    IMinimalMethodSymbol resolveFunction(ITSPHPAst identifier);

    IMinimalMethodSymbol resolveOperator(ITSPHPAst operator);

    IMinimalVariableSymbol resolveReturn(ITSPHPAst returnAst);

    ITypeSymbol resolvePrimitiveType(ITSPHPAst typeASt, ITSPHPAst typeModifierAst);

    /**
     * Try to resolve the type for the given typeAst and returns an
     * {@link IErroneousTypeSymbol} if the type could not be found.
     *
     * @param typeAst The AST node which contains the type name. For instance, int, MyClass, \Exception etc.
     * @return The corresponding type or a {@link IErroneousTypeSymbol} if could not be found.
     */
    ITypeSymbol resolveType(ITSPHPAst typeAst, ITSPHPAst typeModifierAst);

    ITypeSymbol resolveUseType(ITSPHPAst typeAst, ITSPHPAst alias);

    ITypeSymbol resolvePrimitiveLiteral(ITSPHPAst literal);

    IUnionTypeSymbol createUnionTypeSymbol();

    IErroneousTypeSymbol createErroneousTypeSymbol(ITSPHPErrorAst typeAst);

    IErroneousTypeSymbol createErroneousTypeSymbol(ITSPHPAst typeAst, RecognitionException ex);


    boolean checkIsNotDoubleDefinition(ITSPHPAst identifier);

    boolean checkIsNotDoubleDefinitionCaseInsensitive(ITSPHPAst identifier);

    boolean checkUseDefinition(ITSPHPAst alias);

    boolean checkIsNotForwardReference(ITSPHPAst identifier);

    boolean checkIsVariableInitialised(ITSPHPAst variableId);


    void transferInitialisedSymbolsFromGlobalDefault(ITSPHPAst namespace);

    void transferInitialisedSymbolsToGlobalDefault(ITSPHPAst namespace);

    void sendUpInitialisedSymbols(ITSPHPAst blockConditional);

    void sendUpInitialisedSymbolsAfterIf(ITSPHPAst ifBlock, ITSPHPAst elseBlock);

    void sendUpInitialisedSymbolsAfterSwitch(List<ITSPHPAst> conditionalBlocks, boolean hasDefaultLabel);

    void sendUpInitialisedSymbolsAfterTryCatch(List<ITSPHPAst> conditionalBlocks);

    void addImplicitReturnStatementIfRequired(
            boolean isReturning, boolean hasAtLeastOneReturnOrThrow, ITSPHPAst identifier, ITSPHPAst block);

    ITSPHPAst createNullLiteral();

    void createTypeConstraint(ITSPHPAst literal);

    void createRefConstraint(IConstraintCollection collection, ITSPHPAst identifier, ITSPHPAst rhs);

    void createIntersectionConstraint(IConstraintCollection collection, ITSPHPAst operator, ITSPHPAst... arguments);

    void createFunctionCallConstraint(
            IConstraintCollection collection, ITSPHPAst functionCall, ITSPHPAst identifier, ITSPHPAst argumentList);


    void addMethodSymbol(IMethodSymbol scope);

    void solveMethodSymbolConstraints();

    void solveGlobalDefaultNamespaceConstraints();
}
