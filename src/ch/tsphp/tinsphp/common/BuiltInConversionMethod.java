/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.symbols.ITypeSymbol;

public class BuiltInConversionMethod implements IBuiltInConversionMethod
{
    private final ITypeSymbol typeSymbol;
    private ITypeSymbol parentTypeWhichProvidesCast;

    public BuiltInConversionMethod(ITypeSymbol theTypeSymbol) {
        typeSymbol = theTypeSymbol;
    }

    @Override
    public ITSPHPAst createConversionAst(ITSPHPAst ast) {
        throw new UnsupportedOperationException("should not be called, it is a built-int conversion which is not "
                + "defined in user code and hence needs to be created in the translation phase");
    }

    @Override
    public ITypeSymbol getType() {
        return typeSymbol;
    }

    @Override
    public ITypeSymbol getParentTypeWhichProvidesCast() {
        return parentTypeWhichProvidesCast;
    }

    @Override
    public void setParentTypeWhichProvidesCast(ITypeSymbol parentTypeSymbol) {
        parentTypeWhichProvidesCast = parentTypeSymbol;
    }
}
