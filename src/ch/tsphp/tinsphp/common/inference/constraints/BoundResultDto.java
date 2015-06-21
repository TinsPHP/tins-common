/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import ch.tsphp.common.symbols.ITypeSymbol;

import java.util.Map;
import java.util.Set;

/**
 * Represents the result of adding a bound (type or reference) to an IOverloadBindings.
 */
public final class BoundResultDto
{
    public boolean hasChanged;
    public boolean hasChangedOtherBounds;
    public boolean usedImplicitConversion;
    public ITypeSymbol implicitConversionProvider;
    public Map<String, Set<ITypeSymbol>> lowerConstraints;
    public Map<String, Set<ITypeSymbol>> upperConstraints;

    public BoundResultDto() {
    }
}
