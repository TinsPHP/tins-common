/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.checking;

import ch.tsphp.common.symbols.ITypeSymbol;

/**
 * The result of isNotAlreadyDefinedAsType in ISymbolCheckController.
 */
public class AlreadyDefinedAsTypeResultDto
{
    public boolean isNotAlreadyDefinedAsType;
    public ITypeSymbol typeSymbol;

    public AlreadyDefinedAsTypeResultDto() {

    }

    public AlreadyDefinedAsTypeResultDto(boolean itIsNotAlreadyDefinedAsType, ITypeSymbol theTypeSymbol) {
        isNotAlreadyDefinedAsType = itIsNotAlreadyDefinedAsType;
        typeSymbol = theTypeSymbol;
    }
}
