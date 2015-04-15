/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.test.unit.constraints;

import ch.tsphp.tinsphp.common.inference.constraints.FixedTypeVariableConstraint;
import ch.tsphp.tinsphp.common.inference.constraints.ITypeVariableConstraint;
import ch.tsphp.tinsphp.common.inference.constraints.TypeVariableConstraint;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FixedTypeVariableConstraint_TypeVariableConstraint_LSPTest extends TypeVariableConstraintTest
{
    @Test
    @Override
    public void hasFixedType_Standard_ReturnsFalse() {
        //different behaviour, a fixed type variable has a fixed type

        //start same as in TypeVariableConstraintTest
        String typeVariable = "T";

        ITypeVariableConstraint constraint = createTypeVariableConstraint(typeVariable);
        boolean result = constraint.hasFixedType();

        //end same as in TypeVariableConstraintTest
//        assertThat(result, is(false));
        assertThat(result, is(true));
    }

    @Test
    public void toString_Standard_ReturnsTypeVariable() {
        //different behaviour, a fixed type variable additionally returns # as appendix

        //start same as in TypeVariableConstraintTest
        String typeVariable = "T";

        ITypeVariableConstraint constraint = createTypeVariableConstraint(typeVariable);
        String result = constraint.toString();

        //end same as in TypeVariableConstraintTest
//        assertThat(result, is("T"));
        assertThat(result, is("T#"));
    }

    @Override
    protected ITypeVariableConstraint createTypeVariableConstraint(String typeVariable) {
        return new FixedTypeVariableConstraint(new TypeVariableConstraint(typeVariable));
    }

}
