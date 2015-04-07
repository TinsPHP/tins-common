/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

public interface IConstraint
{
    /**
     * Returns a unique identifier in order that it can be stored and found in a HashMap.
     * <p/>
     * So far only types and type variables exist as constraints. Types will return the absolute name of the type where
     * type variables return the name of the type variable with an @ as prefix (to avoid name clashes).
     */
    String getId();
}
