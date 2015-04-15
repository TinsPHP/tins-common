/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.test.unit.constraints;

import ch.tsphp.tinsphp.common.inference.constraints.ITypeVariableConstraint;
import ch.tsphp.tinsphp.common.inference.constraints.TypeVariableConstraint;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TypeVariableConstraintTest
{
    @Test
    public void getId_Standard_ReturnsTypeVariableWithPrefixAt() {
        String typeVariable = "T";

        ITypeVariableConstraint constraint = createTypeVariableConstraint(typeVariable);
        String result = constraint.getId();

        assertThat(result, is("@T"));
    }

    @Test
    public void getTypeVariable_Standard_ReturnsOnePassedByConstructor() {
        String typeVariable = "T";

        ITypeVariableConstraint constraint = createTypeVariableConstraint(typeVariable);
        String result = constraint.getTypeVariable();

        assertThat(result, is("T"));
    }

    @Test
    public void setAndGetTypeVariable_SetANewTypeVariable_ReturnsTheNewTypeVariable() {
        String typeVariable = "T";

        ITypeVariableConstraint constraint = createTypeVariableConstraint(typeVariable);
        constraint.setTypeVariable("T1");
        String result = constraint.getTypeVariable();

        assertThat(result, is("T1"));
    }

    @Test
    public void hasFixedType_Standard_ReturnsFalse() {
        String typeVariable = "T";

        ITypeVariableConstraint constraint = createTypeVariableConstraint(typeVariable);
        boolean result = constraint.hasFixedType();

        assertThat(result, is(false));
    }

    @Test
    public void toString_Standard_ReturnsTypeVariable() {
        String typeVariable = "T";

        ITypeVariableConstraint constraint = createTypeVariableConstraint(typeVariable);
        String result = constraint.toString();

        assertThat(result, is("T"));
    }

    protected ITypeVariableConstraint createTypeVariableConstraint(String typeVariable) {
        return new TypeVariableConstraint(typeVariable);
    }

}
