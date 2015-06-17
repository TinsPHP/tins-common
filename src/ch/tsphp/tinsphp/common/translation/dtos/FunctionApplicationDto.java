/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.translation.dtos;

import java.util.Map;

public class FunctionApplicationDto
{
    /**
     * The name of the function application or null if it was an operator application.
     */
    public String name;
    public Map<Integer, String> runtimeChecks;
    public String returnRuntimeCheck;

    public FunctionApplicationDto(String theName, Map<Integer, String> theRuntimeChecks, String theReturnRuntimeCheck) {
        name = theName;
        runtimeChecks = theRuntimeChecks;
        returnRuntimeCheck = theReturnRuntimeCheck;
    }
}
