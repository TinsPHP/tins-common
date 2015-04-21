/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.translation;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.tinsphp.common.translation.dtos.MethodDto;

import java.util.List;

public interface ITranslatorController
{
    boolean needParentheses(ITSPHPAst expression);

    String getTempVariableName(ITSPHPAst expression);

    String getTempVariableNameIfNotVariable(ITSPHPAst expression);

    List<MethodDto> createMethodDtos(ITSPHPAst identifier);
}
