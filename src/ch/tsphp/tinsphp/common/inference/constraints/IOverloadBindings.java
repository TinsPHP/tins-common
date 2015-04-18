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

    TypeVariableConstraint getNextTypeVariable();

    void addVariable(String variableId, ITypeVariableConstraint constraint);

    boolean containsVariable(String variableId);

    Set<String> getVariableIds();

    ITypeVariableConstraint getTypeVariableConstraint(String variableId);

    void renameTypeVariable(String typeVariable, String newTypeVariable);

    void addLowerRefBound(String typeVariable, ITypeVariableConstraint refTypeVariableConstraint);

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

    boolean tryToFixType(String variableId);

    void resolveDependencies(String variableId, Set<String> dependenciesToIgnore);

    Set<String> getLowerBoundConstraintIds(String typeVariable);

    Set<String> getUpperBoundConstraintIds(String typeVariable);

}
