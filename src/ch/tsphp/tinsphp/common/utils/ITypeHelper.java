/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.utils;

import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.core.IConversionsProvider;

public interface ITypeHelper
{
    void setConversionsProvider(IConversionsProvider conversionProvider);

    void setMixedTypeSymbol(ITypeSymbol typeSymbol);

    boolean areSame(ITypeSymbol firstType, ITypeSymbol secondType);

    /**
     * Indicates whether the given potentialSubType is a subtype of the given typeSymbol considering implicit
     * conversions (coercive subtyping).
     */
    ETypeHelperResult isFirstSameOrSubTypeOfSecond(ITypeSymbol potentialSubType, ITypeSymbol typeSymbol);

    /**
     * Indicates whether the given potentialSubType is a subtype of the given typeSymbol and only considers implicit
     * conversions (coercive subtyping) if desired.
     */
    ETypeHelperResult isFirstSameOrSubTypeOfSecond(
            ITypeSymbol potentialSubType, ITypeSymbol typeSymbol, boolean shallConsiderImplicitConversions);

    /**
     * Indicates whether the given potentialSubType is a parent type of the given typeSymbol considering implicit
     * conversions (coercive subtyping).
     */
    ETypeHelperResult isFirstSameOrParentTypeOfSecond(ITypeSymbol potentialParentType, ITypeSymbol typeSymbol);

    /**
     * Indicates whether the given potentialSubType is a paren type of the given typeSymbol and only considers implicit
     * conversions (coercive subtyping) if desired.
     */
    ETypeHelperResult isFirstSameOrParentTypeOfSecond(
            ITypeSymbol potentialParentType, ITypeSymbol typeSymbol, boolean shallConsiderImplicitConversions);
}
