/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This file is based on the file ISymbolFactory from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.IScope;
import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.exceptions.TSPHPException;
import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.inference.constraints.IBindingCollection;
import ch.tsphp.tinsphp.common.inference.constraints.IConstraint;
import ch.tsphp.tinsphp.common.inference.constraints.IFunctionType;
import ch.tsphp.tinsphp.common.inference.constraints.IVariable;
import ch.tsphp.tinsphp.common.symbols.erroneous.IErroneousLazySymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.IErroneousMethodSymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.IErroneousTypeSymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.IErroneousVariableSymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.ILazySymbolResolver;

import java.util.List;

/**
 * Factory which is able to build all symbols defined in this package.
 */
public interface ISymbolFactory
{

    void setMixedTypeSymbol(ITypeSymbol typeSymbol);

    ITypeSymbol getMixedTypeSymbol();

//    IVoidTypeSymbol createVoidTypeSymbol();

    @SuppressWarnings("checkstyle:parameternumber")
    IScalarTypeSymbol createScalarTypeSymbol(String name, ITypeSymbol parentTypeSymbol,
            int defaultValueTokenType, String defaultValue);

    IArrayTypeSymbol createArrayTypeSymbol(String name, ITypeSymbol keyValue, ITypeSymbol valueType);

    /**
     * Creates and return a PseudoTypeSymbol with the given name and mixed as parent type symbol and isFinal false.
     */
    IPseudoTypeSymbol createPseudoTypeSymbol(String name);

    /**
     * Creates and return a PseudoTypeSymbol with the given name and mixed as parent type symbol.
     */
    IPseudoTypeSymbol createPseudoTypeSymbol(String name, boolean isFinal);

    IPseudoTypeSymbol createPseudoTypeSymbol(String name, ITypeSymbol parentTypeSymbol, boolean isFinal);

    IAliasSymbol createAliasSymbol(ITSPHPAst useDefinition, String alias);

    IAliasTypeSymbol createAliasTypeSymbol(ITSPHPAst definitionAst, String name);

    //    IInterfaceTypeSymbol createInterfaceTypeSymbol(ITSPHPAst modifier, ITSPHPAst identifier, IScope currentScope);

    IClassTypeSymbol createClassTypeSymbol(ITSPHPAst classModifier, ITSPHPAst identifier, IScope currentScope);

    IUnionTypeSymbol createUnionTypeSymbol();

    IIntersectionTypeSymbol createIntersectionTypeSymbol();

    IConvertibleTypeSymbol createConvertibleTypeSymbol();

    IMethodSymbol createMethodSymbol(
            ITSPHPAst methodModifier, ITSPHPAst returnTypeModifier, ITSPHPAst identifier, IScope currentScope);

    IMinimalMethodSymbol createMinimalMethodSymbol(String name);

    IFunctionType createFunctionType(
            String name,
            IBindingCollection bindingCollection,
            List<IVariable> parameters);

//    IVariableSymbol createThisSymbol(ITSPHPAst variableId, IPolymorphicTypeSymbol polymorphicTypeSymbol);

    IVariable createVariable(String name);

    IMinimalVariableSymbol createMinimalVariableSymbol(ITSPHPAst identifier, String name);

    IExpressionVariableSymbol createExpressionVariableSymbol(ITSPHPAst exprAst);

    IVariableSymbol createVariableSymbol(ITSPHPAst typeModifier, ITSPHPAst variableId);

    IErroneousTypeSymbol createErroneousTypeSymbol(ITSPHPAst ast, TSPHPException exception);

    IErroneousMethodSymbol createErroneousMethodSymbol(ITSPHPAst ast, TSPHPException exception);

    IErroneousVariableSymbol createErroneousVariableSymbol(ITSPHPAst ast, TSPHPException exception);

    IErroneousLazySymbol createErroneousLazySymbol(
            ILazySymbolResolver symbolResolver, ITSPHPAst ast, TSPHPException exception);

    IConstraint createConstraint(
            ITSPHPAst operator, IVariable leftHandSide, List<IVariable> arguments, IMinimalMethodSymbol methodSymbol);

    IBindingCollection createBindingCollection();

    IBindingCollection createBindingCollection(IBindingCollection bindingCollectionToCopy);
}
