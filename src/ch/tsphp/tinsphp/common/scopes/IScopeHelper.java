/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This class is based on the class IScopeHelper from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.scopes;

import ch.tsphp.common.ILowerCaseStringMap;
import ch.tsphp.common.IScope;
import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.symbols.ISymbol;

import java.util.List;
import java.util.Map;

/**
 * Includes several helper methods which are used by different scopes.
 */
public interface IScopeHelper
{

    boolean isAbsoluteIdentifier(String identifier);

    boolean isRelativeIdentifier(String identifier);

    boolean isLocalIdentifier(String identifier);

    void define(IScope definitionScope, ISymbol symbol);

    boolean checkIsNotDoubleDefinition(Map<String, List<ISymbol>> symbols, ISymbol symbol);

    boolean checkIsNotDoubleDefinition(Map<String, List<ISymbol>> symbols, ISymbol symbol,
            IAlreadyDefinedMethodCaller errorMethodCaller);

    boolean checkIsNotDoubleDefinition(ISymbol firstDefinition, ISymbol symbolToCheck);

    boolean checkIsNotDoubleDefinition(ISymbol firstDefinition, ISymbol symbolToCheck,
            IAlreadyDefinedMethodCaller errorMethodCaller);

    /**
     * Return the corresponding global namespace from the given globalNamespaceScopes for the given identifier.
     * <p/>
     * As a quick reminder, a namespace identifier always ends with a \ (backslash) for instance:
     * <p/>
     * - \
     * - \ch\
     * - \ch\tsphp\
     *
     * @return The corresponding global namespace or null in the case where it could not be found
     */
    IGlobalNamespaceScope getCorrespondingGlobalNamespace(
            ILowerCaseStringMap<IGlobalNamespaceScope> globalNamespaceScopes, String identifier);

    /**
     * Return the enclosing namespace for the given ast.
     * <p/>
     * As a quick reminder, a namespace identifier always ends with a \ (backslash) for instance:
     * <p/>
     * - \
     * - \ch\
     * - \ch\tsphp\
     *
     * @return The corresponding namespace or null if the ast does not have an enclosing namespace
     */
    INamespaceScope getEnclosingNamespaceScope(ITSPHPAst ast);

    ISymbol resolve(IScope scope, ITSPHPAst ast);


}
