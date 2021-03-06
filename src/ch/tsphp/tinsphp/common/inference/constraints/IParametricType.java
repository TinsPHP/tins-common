/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import ch.tsphp.tinsphp.common.symbols.IParametricTypeSymbol;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * A type which can be configured via type parameters.
 */
public interface IParametricType extends IPolymorphicType
{
    boolean wasBound();

    /**
     * This method can be used to indicate that the given type variable to which this parametric polymorphic type is
     * bound to was fixed in its corresponding overload bindings.
     */
    void fix(String fixedTypeParameter);

    void renameTypeParameter(String typeParameter, String newTypeParameter);

    void bindTo(IBindingCollection newBindingCollection, List<String> bindingTypeParameters);

    /**
     * This method is used to bind this parametric polymorphic type to another parametric polymorphic type without
     * changing the current type variables - it is assumed they already exists in the given overloadBindings.
     *
     * @param newBindingCollection The bindings to which it shall be bound
     */
    void rebind(IBindingCollection newBindingCollection);

    List<String> getTypeParameters();

    Set<String> getNonFixedTypeParameters();

    IBindingCollection getBindingCollection();

    @Override
    IParametricType copy(Collection<IParametricTypeSymbol> parametricTypeSymbols);
}
