/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.test.unit.coverage;

import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.inference.constraints.BoundException;
import ch.tsphp.tinsphp.common.inference.constraints.LowerBoundException;
import ch.tsphp.tinsphp.common.inference.constraints.UpperBoundException;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class BoundExceptionTest
{
    @Test
    public void justToSatisfyTheBuild() {
        new BoundException();
        new LowerBoundException(mock(ITypeSymbol.class), mock(ITypeSymbol.class));
        new UpperBoundException(mock(ITypeSymbol.class), mock(ITypeSymbol.class));
    }
}
