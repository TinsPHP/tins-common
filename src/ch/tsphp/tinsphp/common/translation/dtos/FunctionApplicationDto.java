/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.translation.dtos;

import java.util.List;
import java.util.Set;

public class FunctionApplicationDto
{
    /**
     * The name of the function application or null if it was an operator application.
     */
    public String name;
    public List<Object> arguments;
    /**
     * This arguments do not require further runtime checks because they are already checked in a way.
     * <p/>
     * For instance, the function to call does already incorporate corresponding tests,
     * the argument is converted previous the function call etc.
     */
    public Set<Integer> checkedArguments;
    public String returnRuntimeCheck;

    public FunctionApplicationDto() {
    }

    public FunctionApplicationDto(String theName) {
        name = theName;
    }
}
