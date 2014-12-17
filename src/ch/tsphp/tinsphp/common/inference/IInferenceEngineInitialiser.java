/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference;

import ch.tsphp.tinsphp.common.inference.error.IInferenceErrorReporter;

public interface IInferenceEngineInitialiser
{
    IDefinitionPhaseController getDefinitionPhaseController();

    IReferencePhaseController getReferencePhaseController();

    IInferenceErrorReporter getInferenceErrorReporter();

    /**
     * Resets components which use caches or something similar.
     * This method will be called before a new compilation is run.
     */
    void reset();
}
