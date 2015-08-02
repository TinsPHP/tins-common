/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.translation.dtos;

import ch.tsphp.tinsphp.common.inference.constraints.IBindingCollection;
import ch.tsphp.tinsphp.common.utils.Pair;

import java.util.List;

public final class OverloadDto
{
    public final VariableDto returnVariable;
    public final String identifier;
    public final List<TypeParameterDto> typeParameters;
    public final List<ParameterDto> parameters;
    public final IBindingCollection bindings;
    /**
     * Additional runtime checks for the parameters which need to be performed before the first statement in the
     * function body.
     * <p/>
     * The key denotes the position of the corresponding parameter and the value the corresponding checks.
     */
    public final List<Pair<String, String>> parameterRuntimeChecks;

    public OverloadDto(
            VariableDto theReturnVariable,
            String theIdentifier,
            List<TypeParameterDto> theTypeParameters,
            List<ParameterDto> theParameters,
            IBindingCollection theBindings,
            List<Pair<String, String>> theParameterRuntimeChecks) {
        returnVariable = theReturnVariable;
        identifier = theIdentifier;
        typeParameters = theTypeParameters;
        parameters = theParameters;
        bindings = theBindings;
        parameterRuntimeChecks = theParameterRuntimeChecks;
    }

}
