/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import ch.tsphp.tinsphp.common.symbols.ITypeVariableSymbol;
import ch.tsphp.tinsphp.common.symbols.ITypeVariableSymbolWithRef;

public interface ITypeVariableCollection extends IReadOnlyTypeVariableCollection
{
    /**
     * The given typeVariableSymbol will be added to type variables with constraints which need to be solved.
     */
    void addTypeVariable(ITypeVariableSymbol typeVariableSymbol);

    /**
     * Same behaviour as addTypeVariable but an ITypeVariableSymbolWithRef will be sealed after the constraints of
     * this collection are solved.
     */
    void addTypeVariableWithRef(ITypeVariableSymbolWithRef typeVariableSymbol);
}
