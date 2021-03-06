/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.symbols.ISymbol;
import ch.tsphp.tinsphp.common.inference.constraints.IFunctionType;

import java.util.Collection;

public interface IMinimalMethodSymbol extends ISymbol
{
    void setOverloads(Collection<IFunctionType> overloads);

    Collection<IFunctionType> getOverloads();
}
