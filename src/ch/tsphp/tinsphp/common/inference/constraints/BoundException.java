/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

/**
 * Represents an exception which happens when bounds of a type variable are violated.
 */
public class BoundException extends RuntimeException
{
    public BoundException(String message) {
        super(message);
    }
}
