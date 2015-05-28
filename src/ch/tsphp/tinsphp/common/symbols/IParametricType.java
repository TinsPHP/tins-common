/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.tinsphp.common.inference.constraints.IOverloadBindings;

import java.util.List;

public interface IParametricType extends IObservableTypeSymbol
{
    void renameTypeVariable(String typeVariable, String newTypeVariable);

    void bindTo(IOverloadBindings overloadBindings, List<String> typeVariables);

    IOverloadBindings getOverloadBindings();

    /**
     * Copies the parametric type and binds it to the given overloadBindings.
     * <p/>
     * It is assumed that the mapping between the other parametric type and this type is handled by the other type
     */
    IParametricType copy(IOverloadBindings overloadBindings);
}
