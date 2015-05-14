/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.symbols.IIntersectionTypeSymbol;

public class UpperBoundException extends BoundException
{
    private final IIntersectionTypeSymbol upperTypeBound;
    private final ITypeSymbol newLowerType;

    public UpperBoundException(
            String message, IIntersectionTypeSymbol theUpperTypeBound, ITypeSymbol theNewLowerType) {
        super(message);
        upperTypeBound = theUpperTypeBound;
        newLowerType = theNewLowerType;
    }

    public IIntersectionTypeSymbol getUpperTypeBound() {
        return upperTypeBound;
    }

    public ITypeSymbol getNewLowerType() {
        return newLowerType;
    }
}
