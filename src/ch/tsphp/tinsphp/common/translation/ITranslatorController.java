/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.translation;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.tinsphp.common.inference.constraints.IBindingCollection;
import ch.tsphp.tinsphp.common.symbols.IMethodSymbol;
import ch.tsphp.tinsphp.common.translation.dtos.FunctionApplicationDto;
import ch.tsphp.tinsphp.common.translation.dtos.OverloadDto;
import ch.tsphp.tinsphp.common.translation.dtos.VariableDto;

import java.util.Collection;
import java.util.List;

public interface ITranslatorController
{

    void setMethodSymbols(List<IMethodSymbol> methodSymbols);

    boolean needParentheses(ITSPHPAst expression);

    String getTempVariableName(ITSPHPAst expression);

    String getTempVariableNameIfNotVariable(ITSPHPAst expression);

    Collection<OverloadDto> getOverloadDtos(ITSPHPAst identifier);

    VariableDto createVariableDtoForConstant(IBindingCollection bindings, ITSPHPAst constantId);

    VariableDto createVariableDto(IBindingCollection bindings, ITSPHPAst variableId);

    FunctionApplicationDto getFunctionApplication(
            IBindingCollection bindings, ITSPHPAst functionCall, List<Object> arguments);

    FunctionApplicationDto getOperatorApplication(
            IBindingCollection bindings, ITSPHPAst operator, List<Object> arguments);

    String getErrMessageFunctionApplication(IBindingCollection bindings, ITSPHPAst functionCall, ITSPHPAst identifier);

    String getErrMessageOperatorApplication(IBindingCollection bindings, ITSPHPAst operator);
}
