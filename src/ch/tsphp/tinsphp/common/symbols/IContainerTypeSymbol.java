/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.symbols.ITypeSymbol;

import java.util.Map;

public interface IContainerTypeSymbol extends ITypeSymbol
{
    Map<String, ITypeSymbol> getTypeSymbols();

    /**
     * Adds the given type to this container and indicates whether the container changed or not.
     * <p/>
     * A type might not be added if it already exists in the container or if a constraint (such as a parent type of
     * the given type already exists in the container) fails. In such a case the method returns false because it
     * represents the same type as before.
     */
    boolean addTypeSymbol(ITypeSymbol symbol);
}
