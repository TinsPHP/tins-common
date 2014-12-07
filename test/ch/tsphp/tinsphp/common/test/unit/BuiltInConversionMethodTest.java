/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.test.unit;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.BuiltInConversionMethod;
import ch.tsphp.tinsphp.common.IConversionMethod;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

public class BuiltInConversionMethodTest
{
    @Test
    public void getType_Standard_IsOnePassedByConstructor() {
        ITypeSymbol typeSymbol = mock(ITypeSymbol.class);

        IConversionMethod conversionMethod = createBuiltInConversionMethod(typeSymbol);
        ITypeSymbol result = conversionMethod.getType();

        assertThat(result, is(typeSymbol));
    }

    @Test
    public void getParentTypeWhichProvidesCast_NothingDefined_ReturnsNull() {
        //no arrange necessary

        IConversionMethod conversionMethod = createBuiltInConversionMethod(mock(ITypeSymbol.class));
        ITypeSymbol result = conversionMethod.getParentTypeWhichProvidesCast();

        assertThat(result, is(nullValue()));
    }

    @Test
    public void getParentTypeWhichProvidesCast_OneSet_ReturnsTheOneSetBefore() {
        ITypeSymbol typeSymbol = mock(ITypeSymbol.class);

        IConversionMethod conversionMethod = createBuiltInConversionMethod(mock(ITypeSymbol.class));
        conversionMethod.setParentTypeWhichProvidesCast(typeSymbol);
        ITypeSymbol result = conversionMethod.getParentTypeWhichProvidesCast();

        assertThat(result, is(typeSymbol));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void createConversionAct_Standard_ThrowsUnsupportedOperationException() {
        //no arrange necessary

        IConversionMethod conversionMethod = createBuiltInConversionMethod(mock(ITypeSymbol.class));
        conversionMethod.createConversionAst(mock(ITSPHPAst.class));

        //assert in annotation
    }

    protected IConversionMethod createBuiltInConversionMethod(ITypeSymbol typeSymbol) {
        return new BuiltInConversionMethod(typeSymbol);
    }
}
