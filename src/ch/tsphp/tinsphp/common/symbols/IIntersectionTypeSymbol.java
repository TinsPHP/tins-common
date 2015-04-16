/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.symbols.ITypeSymbol;

public interface IIntersectionTypeSymbol extends IContainerTypeSymbol
{
    /**
     * Adds the given type to this intersection type and indicates whether it has changed.
     * <p/>
     * A type might not be added if it already exists in the intersection type or if a sub type of the given type
     * already exists in the intersection. In this case the method returns false because it represents the same type
     * as before.
     */
    boolean addTypeSymbol(ITypeSymbol symbol);

}
