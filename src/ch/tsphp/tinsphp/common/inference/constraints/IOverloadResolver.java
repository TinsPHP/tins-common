/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import ch.tsphp.common.symbols.ITypeSymbol;

public interface IOverloadResolver
{

    boolean isFirstSubTypeOfSecond(ITypeSymbol potentialSubType, ITypeSymbol typeSymbol);

    boolean isFirstSameOrSubTypeOfSecond(ITypeSymbol potentialSubType, ITypeSymbol typeSymbol);

    boolean isFirstParentTypeOfSecond(ITypeSymbol potentialParentType, ITypeSymbol typeSymbol);

    boolean isFirstSameOrParentTypeOfSecond(ITypeSymbol potentialParentType, ITypeSymbol typeSymbol);

    boolean isSameOrSubType(int promotionLevel);

    /**
     * Return how many promotions have to be applied to the actualParameterType to reach the formalParameterType
     * whereby -1 is returned in the case where formalParameterType is not the actualParameterType or one of its
     * parent types.
     */
    int getPromotionLevelFromTo(ITypeSymbol actualParameterType, ITypeSymbol formalParameterType);
}
