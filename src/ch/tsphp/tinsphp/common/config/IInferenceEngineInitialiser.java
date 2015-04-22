/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.config;

import ch.tsphp.tinsphp.common.IInferenceEngine;
import ch.tsphp.tinsphp.common.scopes.IGlobalNamespaceScope;

public interface IInferenceEngineInitialiser extends IInitialiser
{

    IInferenceEngine getEngine();

    IGlobalNamespaceScope getGlobalDefaultNamespace();
}
