/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.symbols.IUnionTypeSymbol;

/**
 * Represents a lower bound violation which usually occurs if an upper type bound is added which is not a parent type
 * of the current lower type bound.
 */
public class LowerBoundException extends BoundException
{
    private final IUnionTypeSymbol lowerTypeBound;
    private final ITypeSymbol newUpperType;

    public LowerBoundException(
            String message, IUnionTypeSymbol theLowerTypeBound, ITypeSymbol theNewUpperType) {
        super(message);
        lowerTypeBound = theLowerTypeBound;
        newUpperType = theNewUpperType;
    }

    public IUnionTypeSymbol getLowerTypeBound() {

        return lowerTypeBound;
    }

    public ITypeSymbol getNewUpperType() {
        return newUpperType;
    }
}
