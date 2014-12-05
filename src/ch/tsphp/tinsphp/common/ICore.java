/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common;

import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.symbols.resolver.ISymbolResolver;

import java.util.Map;

/**
 * Represents the core of TinsPHP which defines the built-in primitive types, functions,
 * classes and interfaces as well as available operator overloading and implicit/explicit casts.
 */
public interface ICore
{
    //    Map<Integer, List<IMethodSymbol>> getUnaryOperators();
//
//    Map<Integer, List<IMethodSymbol>> getBinaryOperators();
//
//    Map<ITypeSymbol, Map<ITypeSymbol, ICastingMethod>> getImplicitCasting();
//
//    Map<ITypeSymbol, Map<ITypeSymbol, ICastingMethod>> getExplicitCastings();
//
    Map<String, ITypeSymbol> getPrimitiveTypes();

    ISymbolResolver getCoreSymbolResolver();

//    IPseudoTypeSymbol getMixedTypeSymbol();
//
//    IClassTypeSymbol getExceptionTypeSymbol();
//
//    ICastingMethod getStandardCastingMethod(ITypeSymbol formalParameterType);
//
//    void addExplicitCastFromTo(ITypeSymbol actualParameterType, ITypeSymbol formalParameterType);
//
//    void addExplicitCastFromTo(ITypeSymbol actualParameterType, ITypeSymbol formalParameterType,
//            ICastingMethod castingMethod);
//
//    void addImplicitCastFromTo(ITypeSymbol actualParameterType, ITypeSymbol formalParameterType);
//
//    void addImplicitCastFromTo(ITypeSymbol actualParameterType, ITypeSymbol formalParameterType,
//            ICastingMethod castingMethod);
}
