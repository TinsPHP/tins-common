/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This class is based on the class WrongArgumentTypeErrorDto from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.issues;

import ch.tsphp.tinsphp.common.translation.dtos.MethodDto;

import java.util.List;

/**
 * Represents the meta-data of issues which concerns wrong argument types, e.g. wrong method call.
 */
public class WrongArgumentTypeIssueDto extends ReferenceIssueDto
{

    public String[] actualParameterTypes;
    public List<MethodDto> possibleOverloads;

    public WrongArgumentTypeIssueDto(String theIdentifier, int theLine, int thePosition,
            String[] theActualParameterTypes, List<MethodDto> thePossibleOverloads) {
        super(theIdentifier, theLine, thePosition);
        actualParameterTypes = theActualParameterTypes;
        possibleOverloads = thePossibleOverloads;
    }
}
