/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.translation.dtos;

import ch.tsphp.tinsphp.common.inference.constraints.IOverloadBindings;

import java.util.List;

public final class OverloadDto
{
    public final VariableDto returnVariable;
    public final String identifier;
    public final List<TypeParameterDto> typeParameters;
    public final List<ParameterDto> parameters;
    public final IOverloadBindings bindings;


    public OverloadDto(
            VariableDto theReturnVariable,
            String theIdentifier,
            List<TypeParameterDto> theTypeParameters,
            List<ParameterDto> theParameters,
            IOverloadBindings theBindings) {
        returnVariable = theReturnVariable;
        identifier = theIdentifier;
        typeParameters = theTypeParameters;
        parameters = theParameters;
        bindings = theBindings;
    }

}
