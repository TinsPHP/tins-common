/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.checking;

import ch.tsphp.common.ITSPHPAst;

public class ForwardReferenceCheckResultDto
{
    public boolean isNotForwardReference;
    public ITSPHPAst definitionAst;

    public ForwardReferenceCheckResultDto() {
    }

    public ForwardReferenceCheckResultDto(boolean itIsNotForwardReference, ITSPHPAst theDefinitionAst) {
        isNotForwardReference = itIsNotForwardReference;
        definitionAst = theDefinitionAst;
    }
}
