/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.utils.Pair;

import java.util.List;
import java.util.Map;

/**
 * Represents a chosen overload and necessary implicit conversions or runtime check in order that the overload could
 * be applied.
 */
public class OverloadApplicationDto
{
    public IFunctionType overload;
    public Map<Integer, Pair<ITypeSymbol, ITypeSymbol>> implicitConversions;
    public Map<Integer, Pair<ITypeSymbol, List<ITypeSymbol>>> runtimeChecks;

    public OverloadApplicationDto(
            IFunctionType theOverload,
            Map<Integer, Pair<ITypeSymbol, ITypeSymbol>> theImplicitConversions,
            Map<Integer, Pair<ITypeSymbol, List<ITypeSymbol>>> theRuntimeChecks) {
        overload = theOverload;
        implicitConversions = theImplicitConversions;
        runtimeChecks = theRuntimeChecks;
    }
}
