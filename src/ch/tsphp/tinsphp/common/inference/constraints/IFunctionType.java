/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import ch.tsphp.tinsphp.common.symbols.IParametricTypeSymbol;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Represents an overload with parameters and bindings including suffixes for translators.
 */
public interface IFunctionType extends IParametricType
{
    String getName();

    /**
     * This method can be used to indicate that the underlying overload bindings where already simplified and the
     * given typeParameters are to be used.
     * <p/>
     * This method should only be used by the core.
     */
    void simplified(Set<String> typeParameters);

    void simplify();

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

    @Override
    IFunctionType copy(Collection<IParametricTypeSymbol> parametricTypeSymbols);
}
