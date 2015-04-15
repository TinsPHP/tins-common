/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

public class FixedTypeVariableConstraint implements ITypeVariableConstraint
{
    private TypeVariableConstraint constraint;

    public FixedTypeVariableConstraint(TypeVariableConstraint theTypeVariableConstraint) {
        constraint = theTypeVariableConstraint;
    }

    @Override
    public String getTypeVariable() {
        return constraint.getTypeVariable();
    }

    @Override
    public void setTypeVariable(String newTypeVariable) {
        constraint.setTypeVariable(newTypeVariable);
    }

    @Override
    public boolean hasFixedType() {
        return true;
    }

    @Override
    public String getId() {
        return constraint.getId();
    }

    @Override
    public String toString() {
        return constraint.toString() + "#";
    }
}
