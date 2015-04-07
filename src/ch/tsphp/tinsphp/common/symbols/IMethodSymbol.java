/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This file is based on the file IMethodSymbol from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.IScope;
import ch.tsphp.common.symbols.modifiers.ICanBeAbstract;
import ch.tsphp.common.symbols.modifiers.ICanBeFalseable;
import ch.tsphp.common.symbols.modifiers.ICanBeFinal;
import ch.tsphp.common.symbols.modifiers.ICanBeNullable;
import ch.tsphp.common.symbols.modifiers.ICanBeStatic;
import ch.tsphp.common.symbols.modifiers.ICanHaveCastModifier;
import ch.tsphp.tinsphp.common.inference.constraints.IConstraintCollection;

import java.util.List;

/**
 * Represents a method or function definition.
 */
public interface IMethodSymbol extends ISymbolWithAccessModifier, IScope, IConstraintCollection,
        ICanBeStatic, ICanBeFinal, ICanBeAbstract, ICanHaveCastModifier, ICanBeFalseable, ICanBeNullable
{

    void addParameter(IVariableSymbol variableSymbol);

    List<IVariableSymbol> getParameters();

    TypeWithModifiersDto toTypeWithModifiersDto();
}
