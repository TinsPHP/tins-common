/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

/**
 * Represents the result of adding a bound (type or reference) to an IOverloadBindings.
 */
public final class BoundResultDto
{
    public final boolean hasChanged;
    public final boolean hasChangedOtherBounds;
    public final boolean usedImplicitConversion;

    public BoundResultDto(boolean hasItChanged, boolean hasItChangedOtherBounds, boolean wasAnImplicitConversionUsed) {
        hasChanged = hasItChanged;
        hasChangedOtherBounds = hasItChangedOtherBounds;
        usedImplicitConversion = wasAnImplicitConversionUsed;
    }
}
