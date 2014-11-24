/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.symbols.resolver;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.symbols.ISymbol;

/**
 * Coordinates the resolve of symbols (excluding type symbols).
 */
public interface ISymbolResolverController
{
    /**
     * Resolves an identifier considering defined aliases but only if the identifier is relative and falls back to
     * the backup scope iff the identifier is local and was not found in the current scope.
     * <p/>
     * Some examples:
     * <ul>
     * <li>constant
     * <ul>
     * <li>\E_ALL# - absolute identifier, no fallback, does not consider aliases</li>
     * <li>\ch\tsphp\SOME_CONSTANT# - absolute identifier with sub-namespaces, no fallback,
     * does not consider aliases</li>
     * <li>i\am\a\sub\namespace\SOME_CONSTANT# - relative identifier, no fallback but considers aliases</li>
     * <li>E_NOTICE - local identifier, falls back but does not consider aliases</li>
     * </ul>
     * </li>
     * <li>functions</li>
     * <ul>
     * <li>\str_pos() - absolute identifier, no fallback, does not consider aliases</li>
     * <li>\ch\tsphp\foo() - absolute identifier, no fallback, does not consider aliases</li>
     * <li>sub\namespace\bar() - relative identifier, no fallback but considers aliases</li>
     * <li>str_pos() - local identifier, falls back but does not consider aliases</li>
     * </ul>
     * </ul>
     * <p/>
     *
     * @param identifier The identifier which we are looking for. Can be a constant,
     *                   a variable or a function
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveConstantLikeIdentifier(ITSPHPAst identifier);

    /**
     * Resolves an identifier considering defined aliases but only if the identifier is not absolute.
     * <p/>
     * Notice, a fallback mechanism does not apply to class like identifier. Some examples:
     * <ul>
     * <li>\Exception - absolute identifier, no fallback, does not consider aliases</li>
     * <li>\ch\tsphp\SomeInterface - absolute identifier with sub-namespaces, no fallback,
     * does not consider aliases</li>
     * <li>i\am\a\sub\namespace\SomeClass - relative identifier, no fallback but considers aliases</li>
     * <li>ErrorException - local identifier, no fallback but considers aliases</li>
     * </ul>
     * <p/>
     *
     * @param identifier The identifier which we are looking for. Can be a constant,
     *                   a variable or a function
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveClassLikeIdentifier(ITSPHPAst identifier);

    /**
     * Resolves an identifier from its enclosing namespace scope.
     * <p/>
     * A local identifier does not include any namespace information. For instance: E_ALL, foo etc.
     * Variables are not namespace local identifiers since they are scope specific (might be global though).
     *
     * @param identifier The identifier which we are looking for. Can be a constant,
     *                   a variable or a function
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveIdentifierFromItsNamespaceScope(ITSPHPAst identifier);
}
