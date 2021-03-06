/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.utils;

import ch.tsphp.common.symbols.ITypeSymbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Represents the result of the different methods of the ITypeHelper.
 */
public class TypeHelperDto
{
    public ITypeSymbol fromType;
    public ITypeSymbol toType;
    public boolean shallConsiderImplicitConversions;
    public ERelation relation;
    public Map<String, Set<ITypeSymbol>> lowerConstraints;
    public Map<String, Set<ITypeSymbol>> upperConstraints;
    public String typeVariable;

    public TypeHelperDto(
            ITypeSymbol theFromType, ITypeSymbol theToType, boolean considerImplicitConversions) {
        fromType = theFromType;
        toType = theToType;
        shallConsiderImplicitConversions = considerImplicitConversions;
        relation = ERelation.HAS_NO_RELATION;
        lowerConstraints = new HashMap<>();
        upperConstraints = new HashMap<>();
    }
}