/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.symbols.ITypeSymbol;

import java.util.Map;

public interface IUnionTypeSymbol extends IContainerTypeSymbol
{
    Map<String, ITypeSymbol> getTypeSymbols();

    /**
     * Adds the given type to this union and indicates whether this union has changed.
     * <p/>
     * A type might not be added if it already exists in the union or if a parent type of the given type already
     * exists in the union. In this case the method returns false because it represents the same type as before.
     */
    boolean addTypeSymbol(ITypeSymbol symbol);

//    /**
//     * Adds all types of the given union to this union and indicates whether this union has changed.
//     * <p/>
//     * A type might not be added if it already exists in the union or if a parent type of the given type already
//     * exists in the union.
//     */
//    boolean merge(ch.tsphp.common.symbols.IUnionTypeSymbol unionTypeSymbol);
}
