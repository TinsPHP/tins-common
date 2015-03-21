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
import ch.tsphp.common.symbols.IUnionTypeSymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.IErroneousLazySymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.IErroneousMethodSymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.IErroneousTypeSymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.IErroneousVariableSymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.ILazySymbolResolver;

import java.util.List;
import java.util.Map;

/**
 * Factory which is able to build all symbols defined in this package.
 */
public interface ISymbolFactory
{

    void setMixedTypeSymbol(ITypeSymbol typeSymbol);

    ITypeSymbol getMixedTypeSymbol();

    INullTypeSymbol createNullTypeSymbol();

//    IVoidTypeSymbol createVoidTypeSymbol();

    @SuppressWarnings("checkstyle:parameternumber")
    IScalarTypeSymbol createScalarTypeSymbol(String name, ITypeSymbol parentTypeSymbol,
            int defaultValueTokenType, String defaultValue);

    IArrayTypeSymbol createArrayTypeSymbol(String name, ITypeSymbol keyValue, ITypeSymbol valueType);

    /**
     * Create and return a PseudoTypeSymbol with the given name and mixed as parent type symbol.
     */
    IPseudoTypeSymbol createPseudoTypeSymbol(String name);

    IPseudoTypeSymbol createPseudoTypeSymbol(String name, ITypeSymbol parentTypeSymbol);

    IAliasSymbol createAliasSymbol(ITSPHPAst useDefinition, String alias);

    IAliasTypeSymbol createAliasTypeSymbol(ITSPHPAst definitionAst, String name);

    //    IInterfaceTypeSymbol createInterfaceTypeSymbol(ITSPHPAst modifier, ITSPHPAst identifier, IScope currentScope);
//
    IClassTypeSymbol createClassTypeSymbol(ITSPHPAst classModifier, ITSPHPAst identifier, IScope currentScope);

    ITypeVariableSymbol createExpressionTypeVariableSymbol(ITSPHPAst exprAst);

    IUnionTypeSymbol createUnionTypeSymbol();

    IUnionTypeSymbol createUnionTypeSymbol(Map<String, ITypeSymbol> types);

    IOverloadSymbol createOverloadSymbol(String name);

    IFunctionTypeSymbol createConstantFunctionTypeSymbol(
            String name, List<String> parameterIds, ITypeSymbol returnTypeSymbol);

    IFunctionTypeSymbol createPolymorphicFunctionTypeSymbol(
            String name, List<String> parameterIds, Map<String, ITypeVariableSymbol> functionTypeVariables);

    IMethodSymbol createMethodSymbol(
            ITSPHPAst methodModifier, ITSPHPAst returnTypeModifier, ITSPHPAst identifier, IScope currentScope);

//    IVariableSymbol createThisSymbol(ITSPHPAst variableId, IPolymorphicTypeSymbol polymorphicTypeSymbol);

    IVariableSymbol createVariableSymbol(ITSPHPAst typeModifier, ITSPHPAst variableId);

    IErroneousTypeSymbol createErroneousTypeSymbol(ITSPHPAst ast, TSPHPException exception);

    IErroneousMethodSymbol createErroneousMethodSymbol(ITSPHPAst ast, TSPHPException exception);

    IErroneousVariableSymbol createErroneousVariableSymbol(ITSPHPAst ast, TSPHPException exception);

    IErroneousLazySymbol createErroneousLazySymbol(
            ILazySymbolResolver symbolResolver, ITSPHPAst ast, TSPHPException exception);
}
