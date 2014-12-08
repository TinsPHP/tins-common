/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This file is based on the file IScopeFactory from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.scopes;

import ch.tsphp.common.IScope;

/**
 * Factory which is able to build all scopes defined in this package.
 */
public interface IScopeFactory
{

    IGlobalNamespaceScope createGlobalNamespaceScope(String name);

    INamespaceScope createNamespaceScope(String name, IGlobalNamespaceScope currentScope);

    IConditionalScope createConditionalScope(IScope currentScope);
}
