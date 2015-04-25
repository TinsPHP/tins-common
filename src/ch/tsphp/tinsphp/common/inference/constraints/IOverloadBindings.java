/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.symbols.IIntersectionTypeSymbol;
import ch.tsphp.tinsphp.common.symbols.IUnionTypeSymbol;

import java.util.Set;

public interface IOverloadBindings
{

    TypeVariableReference getNextTypeVariable();

    void addVariable(String variableId, ITypeVariableReference reference);

    boolean containsVariable(String variableId);

    ITypeVariableReference getTypeVariableReference(String variableId);

    Set<String> getVariableIds();

    void addLowerRefBound(String typeVariable, ITypeVariableReference reference);

    void addLowerTypeBound(String typeVariable, ITypeSymbol typeSymbol);

    void addUpperTypeBound(String typeVariable, ITypeSymbol typeSymbol);

    boolean hasLowerRefBounds(String typeVariable);

    boolean hasUpperRefBounds(String typeVariable);

    boolean hasLowerTypeBounds(String typeVariable);

    boolean hasUpperTypeBounds(String typeVariable);

    boolean hasLowerBounds(String typeVariable);

    boolean hasUpperBounds(String typeVariable);

    IUnionTypeSymbol getLowerTypeBounds(String typeVariable);

    IIntersectionTypeSymbol getUpperTypeBounds(String typeVariable);

    Set<String> getLowerRefBounds(String typeVariable);

    Set<String> getUpperRefBounds(String typeVariable);

    Set<String> getLowerBoundConstraintIds(String typeVariable);

    Set<String> getUpperBoundConstraintIds(String typeVariable);

    /**
     * Returns the overload which was taken for this expression node.
     *
     * @return
     */
    IFunctionType getAppliedOverload(String variableId);

    /**
     * Sets the overload which was taken for the given expression node.
     * <p/>
     * For instance, if the expression node represents the + operator then multiple overloads can be taken. To name
     * just two of them:
     * <p/>
     * -  T x T -> T \ T < num
     * -  bool x bool -> int
     * <p/>
     * Let's say the first overload was taken, in this case we store this information via this method in the
     * binding
     */
    void setAppliedOverload(String variableId, IFunctionType overload);

    void fixType(String variableId);

    /**
     * Is meant for function bindings and reduces the non-fixed (free) type variables to the ones which have a lower
     * ref to a parameter which itself has not a fixed type.
     *
     * @param parameterTypeVariables The typeVariables of the parameters of the function
     */
    void tryToFix(Set<String> parameterTypeVariables);

    void renameTypeVariable(String typeVariable, String newTypeVariable);

}
