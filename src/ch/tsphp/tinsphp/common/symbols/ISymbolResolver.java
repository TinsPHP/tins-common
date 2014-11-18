/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.symbols;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.symbols.ISymbol;

/**
 * Represents a member of the ISymbol-resolving-chain-of-responsibility.
 * <p/>
 * Each member in the symbol-resolving-chain provides various methods to resolve symbols (constants,
 * variables and function calls). If a member does not find the corresponding symbol to a given identifier, then
 * it passes it along the chain to the next member. If the member was the last one then it returns null.
 * <p/>
 * Some examples of possible members are UserSymbolResolver (resolve user defined symbols) and CoreSymbolResolver
 * (resolves predefined symbols).
 */
public interface ISymbolResolver
{
    /**
     * Resolves the given identifier from its scope.
     *
     * @param identifier The identifier which we are looking for.
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveIdentifierFromItsScope(ITSPHPAst identifier);

    /**
     * Resolves an identifier from its scope and falls back to a backup scope (usually the global default namespace
     * scope) if the identifier was not found.
     *
     * @param identifier The identifier which we are looking for.
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveIdentifierFromItsScopeWithFallback(ITSPHPAst identifier);

    /**
     * Resolves an identifier from the backup scope (usually the global default namespace scope).
     * <p/>
     * This method will be used by the first resolver in the resolving-chain. This way the
     * resolveIdentifierWithFallback method can easily be implemented by first invoking
     * resolveIdentifier (traversing the resolving-chain) and then look only in the backup scope.
     *
     * @param identifier The identifier which we are looking for.
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveIdentifierFromFallback(ITSPHPAst identifier);

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
     * Resolves an absolute identifier.
     * <p/>
     * The identifier is resolved from the namespace scope with the corresponding id. For instance,
     * \E_ALL is resolved from the namespace \, \ch\tsphp\SomeClass is resolved from the namespace \ch\tsphp\
     * <p/>
     * This method shall be used as shortcut when invoking a next member in the chain and the current member has
     * already verified that the given identifier is absolute.
     *
     * @param identifier The identifier which we are looking for. Can be a constant,
     *                   a variable or a function
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveAbsoluteIdentifier(ITSPHPAst identifier);

    /**
     * Resolves a relative identifier.
     * <p/>
     * The identifier is resolved from the sub-namespace scope with the corresponding id. For instance,
     * assuming the identifier is within the namespace \ch\, then the identifier tsphp\SomeClass is resolved from the
     * namespace \ch\tsphp\
     * <p/>
     * This method shall be used as shortcut when invoking a next member in the chain and the current member has
     * already verified that the given identifier is relative.
     *
     * @param identifier The identifier which we are looking for. Can be a constant,
     *                   a variable or a function
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveRelativeIdentifier(ITSPHPAst identifier);

    /**
     * Resolves an identifier from its enclosing namespace scope.
     * <p/>
     * A local identifier does not include any namespace information. For instance: E_ALL, foo etc.
     * Variables are not namespace local identifiers since they
     * <p/>
     * This method shall be used as shortcut when invoking a next member in the chain and the current member has
     * already verified that the given identifier is local.
     *
     * @param identifier The identifier which we are looking for. Can be a constant,
     *                   a variable or a function
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveIdentifierFromItsNamespaceScope(ITSPHPAst identifier);

    /**
     * Defines the next resolver in the resolving-chain.
     */
    void setNextInChain(ISymbolResolver symbolResolver);
}

