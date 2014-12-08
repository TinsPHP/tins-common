/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This file is based on the file ISymbolWithAccessModifier from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.symbols.ISymbolWithModifier;
import ch.tsphp.common.symbols.modifiers.ICanBePrivate;
import ch.tsphp.common.symbols.modifiers.ICanBeProtected;
import ch.tsphp.common.symbols.modifiers.ICanBePublic;

/**
 * Represents a symbol which has modifiers and especially can be public, protected or private.
 */
public interface ISymbolWithAccessModifier extends ISymbolWithModifier, ICanBePublic, ICanBeProtected, ICanBePrivate
{

}
