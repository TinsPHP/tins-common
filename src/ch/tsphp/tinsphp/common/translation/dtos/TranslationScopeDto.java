/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.translation.dtos;

import ch.tsphp.tinsphp.common.inference.constraints.IBindingCollection;

import java.util.Deque;

public final class TranslationScopeDto
{
    public final IBindingCollection bindingCollection;
    /**
     * Statements which need to be included additionally at the beginning of the translation scope
     */
    public final Deque<String> statements;


    public TranslationScopeDto(IBindingCollection theBindingCollection, Deque<String> theStatements) {
        bindingCollection = theBindingCollection;
        statements = theStatements;
    }
}
