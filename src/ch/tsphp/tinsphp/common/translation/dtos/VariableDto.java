/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.translation.dtos;

public final class VariableDto
{
    public final TypeParameterDto typeParameter;
    public final String type;
    public final String variableId;

    public VariableDto(TypeParameterDto theTypeParameter, String theType, String theVariableId) {
        typeParameter = theTypeParameter;
        type = theType;
        variableId = theVariableId;
    }
}
