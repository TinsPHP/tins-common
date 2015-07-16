/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.translation;

import ch.tsphp.tinsphp.common.inference.constraints.IBindingCollection;
import ch.tsphp.tinsphp.common.inference.constraints.IVariable;
import ch.tsphp.tinsphp.common.symbols.IMethodSymbol;
import ch.tsphp.tinsphp.common.translation.dtos.OverloadDto;
import ch.tsphp.tinsphp.common.translation.dtos.VariableDto;

import java.util.Collection;

/**
 * Is responsible to create meta-data dtos.
 */
public interface IDtoCreator
{
    Collection<OverloadDto> createOverloadDtos(IMethodSymbol methodSymbol);

    VariableDto createVariableDtoForConstant(IBindingCollection bindings, IVariable constant);

    VariableDto createVariableDto(IBindingCollection bindings, IVariable variable);
}
