/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.tinsphp.common.inference.constraints.IOverloadBindings;

import java.util.Collection;
import java.util.List;

public interface IParametricTypeSymbol extends IPolymorphicTypeSymbol, IObservableTypeSymbol
{
    boolean wasBound();

    boolean isFixed();

    void renameTypeVariable(String typeVariable, String newTypeVariable);

    void bindTo(IOverloadBindings overloadBindings, List<String> typeVariables);

    /**
     * This method is used to bind this parametric polymorphic type to another parametric polymorphic type without
     * changing the current type variables - it is assumed they already exists in the given overloadBindings.
     *
     * @param overloadBindings The bindings to which it shall be bound
     * @return The type variables used by this parametric polymorphic type
     */
    List<String> rebind(IOverloadBindings overloadBindings);

    List<String> getTypeVariables();

    IOverloadBindings getOverloadBindings();

    @Override
    IParametricTypeSymbol copy(Collection<IParametricTypeSymbol> parametricTypeSymbols);
}
