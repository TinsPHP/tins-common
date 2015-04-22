/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

/**
 * Represents the binding between a variable and a type variable where the variable has not (yet) a fixed type.
 */
public class TypeVariableReference implements ITypeVariableReference
{
    private String typeVariable;

    public TypeVariableReference(String theTypeVariable) {
        typeVariable = theTypeVariable;
    }

    public String getTypeVariable() {
        return typeVariable;
    }

    public void setTypeVariable(String newTypeVariable) {
        typeVariable = newTypeVariable;
    }

    @Override
    public boolean hasFixedType() {
        return false;
    }

    @Override
    public String toString() {
        return typeVariable;
    }
}

