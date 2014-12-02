/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This class is based on the class IScalarTypeSymbol from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.symbols.ITypeSymbol;

/**
 * Represents a scalar type such as bool, int, float and string.
 * <p/>
 * String is considered as scalar type since there is not a smaller type such as char as in other languages.
 */
public interface IScalarTypeSymbol extends ITypeSymbol
{

}
