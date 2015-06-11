/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.config;

import ch.tsphp.tinsphp.common.IInferenceEngine;
import ch.tsphp.tinsphp.common.scopes.IGlobalNamespaceScope;
import ch.tsphp.tinsphp.common.symbols.IMethodSymbol;

import java.util.List;

/**
 * Responsible to initialise the inference engine component.
 */
public interface IInferenceEngineInitialiser extends IInitialiser
{

    IInferenceEngine getEngine();

    IGlobalNamespaceScope getGlobalDefaultNamespace();

    List<IMethodSymbol> getMethodSymbols();
}
