/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.resolving;

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
     * Resolves the given identifier from its scope in a case insensitive manner.
     *
     * @param identifier The identifier which we are looking for.
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveIdentifierFromItsScopeCaseInsensitive(ITSPHPAst identifier);

    /**
     * Resolves the given identifier from the backup scope (usually the global default namespace scope).
     *
     * @param identifier The identifier which we are looking for.
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveIdentifierFromFallback(ITSPHPAst identifier);

    /**
     * Resolves the given absolute identifier.
     * <p/>
     * The identifier is resolved from the namespace scope with the corresponding id. For instance,
     * \E_ALL is resolved from the namespace \, \ch\tsphp\SomeClass is resolved from the namespace \ch\tsphp\
     *
     * @param identifier The identifier which we are looking for.
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveAbsoluteIdentifier(ITSPHPAst identifier);

    /**
     * Resolves the given identifier from its enclosing namespace scope.
     * <p/>
     * A local identifier does not include any namespace information. For instance: E_ALL, foo etc.
     * Variables are not namespace local identifiers since they are scope specific (might be global though).
     *
     * @param identifier The identifier which we are looking for.
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveIdentifierFromItsNamespaceScope(ITSPHPAst identifier);

    /**
     * Resolves the given identifier from the super global scope.
     *
     * @param identifier The identifier which we are looking for.
     * @return The corresponding symbol if the identifier was found otherwise null.
     */
    ISymbol resolveIdentifierFromSuperGlobalScope(ITSPHPAst identifier);
}

