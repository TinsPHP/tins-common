/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.symbols.ITypeSymbol;

import java.util.Collection;

public interface IPolymorphicTypeSymbol extends ITypeSymbol
{
    /**
     * Makes a copy of this polymorphic type and adds all containing parametric type symbols to the given collection.
     * <p/>
     * As an example, copying a union type symbol will return a copy of
     *
     * @param parametricTypeSymbols
     * @return
     */
    IPolymorphicTypeSymbol copy(Collection<IParametricTypeSymbol> parametricTypeSymbols);

    boolean isFixed();
}
