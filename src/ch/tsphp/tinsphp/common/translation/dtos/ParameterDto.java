/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.translation.dtos;

public final class ParameterDto
{
    public final TypeDto type;
    public final String parameterId;
    public final String defaultValue;
    /**
     * A parameter can have a defined type hint in which case a local variable needs to be created in addition.
     */
    public final TypeDto typeHint;
    public final String localVariableId;

    public ParameterDto(
            TypeDto theType,
            String theParameterId,
            String theDefaultValue,
            TypeDto theTypeHint,
            String theLocalVariableId) {
        type = theType;
        parameterId = theParameterId;
        defaultValue = theDefaultValue;
        typeHint = theTypeHint;
        localVariableId = theLocalVariableId;
    }
}
