/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.symbols.ITypeSymbol;

import java.util.Collection;

public interface IUnionTypeSymbol extends IContainerTypeSymbol
{
    /**
     * Adds the given type to this union and indicates whether this union has changed.
     * <p/>
     * A type might not be added if it already exists in the union or if a parent type of the given type already
     * exists in the union. In this case the method returns false because it represents the same type as before.
     */
    @Override
    boolean addTypeSymbol(ITypeSymbol symbol);

    @Override
    IUnionTypeSymbol copy(Collection<IParametricTypeSymbol> parametricTypeSymbols);
}
