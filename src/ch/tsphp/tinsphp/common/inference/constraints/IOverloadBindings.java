/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import ch.tsphp.common.symbols.ITypeSymbol;
import ch.tsphp.tinsphp.common.symbols.IIntersectionTypeSymbol;
import ch.tsphp.tinsphp.common.symbols.IUnionTypeSymbol;

import java.util.List;
import java.util.Set;

public interface IOverloadBindings
{

    /**
     * Creates a temporary variable and returns its corresponding type variable reference.
     */
    ITypeVariableReference createHelperVariable();

    ITypeVariableReference getNextTypeVariable();

    void addVariable(String variableId, ITypeVariableReference reference);

    boolean containsVariable(String variableId);

    ITypeVariableReference getTypeVariableReference(String variableId);

    String getTypeVariable(String variableId);

    Set<String> getVariableIds();

    Set<String> getVariableIds(String typeVariable);

    BoundResultDto addLowerRefBound(String typeVariable, ITypeVariableReference reference);

    BoundResultDto addLowerTypeBound(String typeVariable, ITypeSymbol typeSymbol);

    BoundResultDto addUpperTypeBound(String typeVariable, ITypeSymbol typeSymbol);

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
     * Returns the application information which was taken for the expression node with the given id
     */
    OverloadApplicationDto getAppliedOverload(String variableId);

    /**
     * Sets the applied overload (including conversions and runtime checks) for the expression node with the given
     * variableId.
     * <p/>
     * For instance, if the expression node represents the + operator then multiple overloads can be taken. To name
     * just two of them:
     * <p/>
     * -  int x int -> int
     * -  {as T} x {as T} -> T \ T <: num
     * <p/>
     * Let's say the first overload was taken, in this case we store this information via this method in the
     * binding. Furthermore, we define whether the application included any implicit conversion or
     */
    void setAppliedOverload(String variableId, OverloadApplicationDto dto);

    void fixType(String variableId);

    void fixTypeParameter(String typeParameter);

    /**
     * Fixes all type variables which are bound to a parametric type.
     */
    void fixTypeParameters();

    /**
     * Is meant for function bindings and fixes all type variables which (i) have no lower ref relation to a parameter
     * which is not fixed (ii) are not a type parameter of a parametric type -- the method returns all non-fixed type
     * variables.
     *
     * @param parameterTypeVariables The typeVariables of the parameters of the function
     * @return All non-fixed (hence polymorphic) type variables
     */
    Set<String> tryToFix(Set<String> parameterTypeVariables);

    void mergeFirstIntoSecond(String firstTypeVariable, String secondTypeVariable);

    /**
     * Renames the given typeVariable to the given newName.
     */
    void renameTypeVariable(String typeVariable, String newName);

    void bind(IParametricType parametricType, List<String> typeVariables);

    int getNumberOfConvertibleApplications();

    void changeToSoftTypingMode();

    void changeToModificationMode();

    void changeToNormalMode();

    boolean isNotInSoftTypingMode();

    void setLowerTypeBounds(String typeVariable, IUnionTypeSymbol lowerTypeBound);

    void setUpperTypeBounds(String typeVariable, IIntersectionTypeSymbol upperTypeBound);

    IUnionTypeSymbol removeLowerTypeBounds(String typeVariable);

    IIntersectionTypeSymbol removeUpperTypeBounds(String typeVariable);
}
