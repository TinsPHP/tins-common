/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.config;

/**
 * An initialiser is responsible to initialise and reinitialise its corresponding component.
 * <p/>
 * Furthermore, it exposes the interfaces which can be used from the outside of this component
 */
public interface IInitialiser
{
    /**
     * Resets classes which use caches or something similar and need to be recreated for a new run.
     * This method should be called before a new compilation is run.
     */
    void reset();
}
