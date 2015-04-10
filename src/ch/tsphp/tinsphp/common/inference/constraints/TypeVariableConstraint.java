/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

public class TypeVariableConstraint implements IConstraint
{
    private boolean hasFixedType = false;
    private String typeVariable;

    public TypeVariableConstraint(String theTypeVariable) {
        typeVariable = theTypeVariable;
    }

    public String getTypeVariable() {
        return typeVariable;
    }

    public void setTypeVariable(String newTypeVariable) {
        typeVariable = newTypeVariable;
    }

    public boolean hasFixedType() {
        return hasFixedType;
    }

    public void setHasFixedType() {
        hasFixedType = true;
    }

    @Override
    public String getId() {
        return "@" + typeVariable;
    }

    @Override
    public String toString() {
        return typeVariable + (hasFixedType ? "#" : "");
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TypeVariableConstraint
                && ((TypeVariableConstraint) obj).typeVariable.equals(typeVariable);
    }

    @Override
    public int hashCode() {
        return typeVariable.hashCode();
    }
}

