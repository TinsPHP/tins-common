/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.resolving;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.symbols.ITypeSymbol;

/**
 * Represents a member of the ITypeSymbol-resolving-chain-of-responsibility.
 * <p/>
 * Each member in the ITypeSymbol-resolving-chain provides a method resolveTypeFor which shall resolve a type for a
 * given ITSPHPAst. If a member does not support the type of the given AST or does not find the corresponding type, then
 * it passes it along the chain to the next member. If the member was the last one then it returns null.
 */
public interface ITypeSymbolResolver
{
    /**
     * Resolves the type of the given ast where ast can either be a definition (constant, variable,
     * function/method - their parameters respectively) or an expression (assignment, function/method call,
     * new Operator, a constant, a variable etc.).
     *
     * @param ast The ast for which a type shall be resolved.
     * @return The corresponding type if the typeName was found otherwise null.
     */
    ITypeSymbol resolveTypeFor(ITSPHPAst ast);

    /**
     * Defines the next resolver in the resolving-chain.
     */
    void setNextInChain(ITypeSymbolResolver symbolResolver);
}
