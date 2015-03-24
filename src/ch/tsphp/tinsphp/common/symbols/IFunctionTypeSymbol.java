/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.symbols;


import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.inference.constraints.IConstraint;

import java.util.List;

public interface IFunctionTypeSymbol extends ITypeSymbol, IConstraint
{
    void addInputConstraint(String parameterId, IConstraint constraint);

    void addOutputConstraint(String parameterId, IConstraint constraint);

    List<List<IConstraint>> getInputConstraints();

    List<List<IConstraint>> getOutputConstraints();

    ITypeSymbol apply(List<ITypeVariableSymbol> arguments);
}
