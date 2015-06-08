/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.symbols.IIntersectionTypeSymbol;

/**
 * Occurs if a concrete type should be added to an upper type bound and a concrete type is already in the upper type
 * bound.
 * <p/>
 * E.g. when adding Foo (a class) as upper bound and Bar (another class) is already in the upper bound. An upper
 * bound can only contain one concrete type in PHP.
 */
public class IntersectionBoundException extends UpperBoundException
{
    public IntersectionBoundException(
            String message, IIntersectionTypeSymbol theUpperTypeBound, ITypeSymbol theNewLowerType) {
        super(message, theUpperTypeBound, theNewLowerType);
    }
}
