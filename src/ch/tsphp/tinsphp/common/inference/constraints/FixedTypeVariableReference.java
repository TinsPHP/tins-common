/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

/**
 * A reference to a type variable where the corresponding variable which holds the reference has a fixed type.
 */
public class FixedTypeVariableReference implements ITypeVariableReference
{
    private TypeVariableReference reference;

    public FixedTypeVariableReference(TypeVariableReference theTypeVariableConstraint) {
        reference = theTypeVariableConstraint;
    }

    @Override
    public String getTypeVariable() {
        return reference.getTypeVariable();
    }

    @Override
    public void setTypeVariable(String newTypeVariable) {
        reference.setTypeVariable(newTypeVariable);
    }

    @Override
    public boolean hasFixedType() {
        return true;
    }

    @Override
    public String toString() {
        return reference.toString() + "#";
    }
}
