/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.translation.dtos;

import java.util.List;

public final class TypeDto
{
    public final List<String> prefixModifiers;
    public final String type;
    public final List<String> suffixModifiers;

    public TypeDto(List<String> thePrefixModifiers, String theType, List<String> theSuffixModifiers) {
        prefixModifiers = thePrefixModifiers;
        type = theType;
        suffixModifiers = theSuffixModifiers;
    }
}
