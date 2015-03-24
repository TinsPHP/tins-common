/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.tinsphp.common.inference.constraints.ITypeVariableCollection;
import ch.tsphp.tinsphp.common.symbols.IMethodSymbol;

public interface IInferencePhaseController
{

    void createRefVariable(ITypeVariableCollection collection, ITSPHPAst variableId);

    void createTypeConstraint(ITSPHPAst literal);

    void createRefConstraint(ITypeVariableCollection collection, ITSPHPAst identifier, ITSPHPAst rhs);

    void createIntersectionConstraint(ITypeVariableCollection collection, ITSPHPAst operator, ITSPHPAst... arguments);

    void addTypeVariableCollection(IMethodSymbol scope);

    void solveAllConstraints();
}
