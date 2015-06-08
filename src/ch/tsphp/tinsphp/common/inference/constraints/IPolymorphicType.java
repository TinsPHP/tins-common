/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import ch.tsphp.tinsphp.common.symbols.IParametricTypeSymbol;

import java.util.Collection;

/**
 * A type which can hold parametric types and is therefore not fixed, polymorphic respectively.
 */
public interface IPolymorphicType
{
    /**
     * Makes a copy of this polymorphic type and adds all containing parametric type symbols to the given collection.
     * <p/>
     * As an example, copying a union type symbol will return a copy of
     *
     * @param parametricTypeSymbols
     * @return
     */
    IPolymorphicType copy(Collection<IParametricTypeSymbol> parametricTypeSymbols);

    boolean isFixed();
}
