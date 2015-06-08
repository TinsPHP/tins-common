/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

/**
 * A reference to a type variable -- allows to rename a type variable and indicates whether the type
 * variable has a fixed type.
 */
public interface ITypeVariableReference
{
    String getTypeVariable();

    void setTypeVariable(String newTypeVariable);

    boolean hasFixedType();
}
