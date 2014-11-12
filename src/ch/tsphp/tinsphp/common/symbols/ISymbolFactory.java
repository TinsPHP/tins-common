/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This class is based on the class ISymbolFactory from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.IScope;
import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.exceptions.TSPHPException;
import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.IErroneousMethodSymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.IErroneousTypeSymbol;
import ch.tsphp.tinsphp.common.symbols.erroneous.IErroneousVariableSymbol;

/**
 * Factory which is able to build all symbols defined in this package.
 */
public interface ISymbolFactory
{

    void setMixedTypeSymbol(ITypeSymbol typeSymbol);

    INullTypeSymbol createNullTypeSymbol();

    //
//    IVoidTypeSymbol createVoidTypeSymbol();
//
//    @SuppressWarnings("checkstyle:parameternumber")
//    IScalarTypeSymbol createScalarTypeSymbol(String name, int tokenType, Set<ITypeSymbol> parentTypeSymbol,
//            int defaultValueTokenType, String defaultValue);
//
//    IArrayTypeSymbol createArrayTypeSymbol(String name, int tokenType, ITypeSymbol keyValue, ITypeSymbol valueType);
//
//    IPseudoTypeSymbol createPseudoTypeSymbol(String name);
//
    IAliasSymbol createAliasSymbol(ITSPHPAst useDefinition, String alias);

    IAliasTypeSymbol createAliasTypeSymbol(ITSPHPAst definitionAst, String name);
//
//    IInterfaceTypeSymbol createInterfaceTypeSymbol(ITSPHPAst modifier, ITSPHPAst identifier, IScope currentScope);
//
//    IClassTypeSymbol createClassTypeSymbol(ITSPHPAst classModifier, ITSPHPAst identifier, IScope currentScope);

    IMethodSymbol createMethodSymbol(ITSPHPAst methodModifier, ITSPHPAst returnTypeModifier, ITSPHPAst identifier,
            IScope currentScope);

    //
//    IVariableSymbol createThisSymbol(ITSPHPAst variableId, IPolymorphicTypeSymbol polymorphicTypeSymbol);

    IVariableSymbol createVariableSymbol(ITSPHPAst typeModifier, ITSPHPAst variableId);

    IErroneousTypeSymbol createErroneousTypeSymbol(ITSPHPAst ast, TSPHPException exception);

    IErroneousMethodSymbol createErroneousMethodSymbol(ITSPHPAst ast, TSPHPException exception);

    IErroneousVariableSymbol createErroneousVariableSymbol(ITSPHPAst ast, TSPHPException exception);
}
