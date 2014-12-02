/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This class is based on the class IPseudoTypeSymbol from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.symbols.ISymbol;
import ch.tsphp.common.symbols.ISymbolWithModifier;
import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.common.symbols.modifiers.ICanBeAbstract;
import ch.tsphp.tinsphp.common.scopes.ICaseInsensitiveScope;

import java.util.Set;

public interface IPolymorphicTypeSymbol extends ITypeSymbol, ISymbolWithModifier, ICaseInsensitiveScope, ICanBeAbstract
{

    ISymbol resolveWithFallbackToParent(ITSPHPAst ast);

    void addParentTypeSymbol(IPolymorphicTypeSymbol aParent);

    Set<ISymbol> getAbstractSymbols();

}
