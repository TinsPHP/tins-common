/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.translation.dtos;

import java.util.List;

public final class TypeParameterDto
{
    public final List<String> lowerBounds;
    public final String typeVariable;
    public final List<String> upperBounds;

    public TypeParameterDto(List<String> theLowerBounds, String theTypeVariable, List<String> theUpperBounds) {
        lowerBounds = theLowerBounds;
        typeVariable = theTypeVariable;
        upperBounds = theUpperBounds;
    }
}
