/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import java.util.List;

/**
 * Represents an overload with parameters and bindings including suffixes for translators.
 */
public interface IFunctionType
{
    String getName();

    /**
     * Marks that a function will not change anymore (its bindings respectively) and hence can calculate its
     * signature and fix it as well.
     */
    void fix();

    /**
     * The signature of this function if it can be determined already otherwise null.
     * <p/>
     * A signature can be determined if the function was fixed.
     */
    String getSignature();

    /**
     * Returns a suffix if the translator with the given id had to rewrite the function.
     * <p/>
     * It might be necessary that a translator rewrites the name of an overload (for instance if the target language
     * does not support overloading).
     */
    String getSuffix(String translatorId);

    void addSuffix(String translatorId, String newName);

    int getNumberOfNonOptionalParameters();

    List<IVariable> getParameters();

    IOverloadBindings getBindings();
}
