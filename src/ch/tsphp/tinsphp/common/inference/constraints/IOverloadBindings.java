/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface IOverloadBindings
{
    Map<String, ITypeVariableConstraint> getVariable2TypeVariable();

    boolean tryToFixateType(String variableId);

    void resolveDependencies(String variableId, Set<String> dependenciesToIgnore);

    void renameTypeVariable(ITypeVariableConstraint typeVariableConstraint, String newName);

    TypeVariableConstraint getNextTypeVariable();

    void addLowerBound(String typeVariable, IConstraint newLowerBoundConstraint);

    void addUpperBound(String typeVariable, IConstraint newUpperBoundConstraint);

    boolean hasLowerBounds(String typeVariable);

    boolean hasUpperBounds(String typeVariable);

    Collection<IConstraint> getLowerBounds(String typeVariable);

    Collection<IConstraint> getUpperBounds(String typeVariable);

    Set<String> getLowerBoundConstraintIds(String typeVariable);

    Set<String> getUpperBoundConstraintIds(String typeVariable);

    Set<String> getTypeVariablesWithLowerBounds();

    Set<String> getTypeVariablesWithUpperBounds();
}
