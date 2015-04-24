/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This class is based on the class AErrorMessageProvider from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.issues;

import ch.tsphp.tinsphp.common.translation.dtos.MethodDto;
import ch.tsphp.tinsphp.common.translation.dtos.ParameterDto;
import ch.tsphp.tinsphp.common.translation.dtos.TypeParameterDto;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Provide some helper methods for IErrorMessageProviders.
 * <p/>
 * However, it does not define how error messages are load and does leave it to the concrete sub-classes.
 */
public abstract class AIssueMessageProvider implements IIssueMessageProvider
{

    private Map<String, String> definitionIssues;
    private Map<String, String> referenceIssues;
    private Map<String, String> wrongArgumentTypeIssues;

    protected abstract Map<String, String> loadDefinitionIssueMessages();

    protected abstract Map<String, String> loadReferenceIssueMessages();

    protected abstract Map<String, String> loadWrongArgumentTypeIssueMessages();

    protected abstract String getStandardDefinitionIssueMessage(String identifier, DefinitionIssueDto dto);

    protected abstract String getStandardReferenceIssueMessage(String identifier, ReferenceIssueDto dto);

    protected abstract String getStandardWrongArgumentTypeIssueMessage(String identifier,
            WrongArgumentTypeIssueDto dto);


    @Override
    public String getDefinitionIssueMessage(String identifier, DefinitionIssueDto dto) {
        String message;
        if (definitionIssues == null) {
            definitionIssues = loadDefinitionIssueMessages();
        }
        if (definitionIssues.containsKey(identifier)) {
            message = definitionIssues.get(identifier);

            message = message.replace("%id%", "");
            message = message.replace("%line%", Integer.toString(dto.line));
            message = message.replace("%pos%", Integer.toString(dto.position));

            message = message.replace("%idN%", dto.identifierNewDefinition);
            message = message.replace("%lineN%", Integer.toString(dto.lineNewDefinition));
            message = message.replace("%posN%", Integer.toString(dto.positionNewDefinition));

        } else {
            message = getStandardDefinitionIssueMessage(identifier, dto);
        }
        return message;
    }

    @Override
    public String getReferenceIssueMessage(String identifier, ReferenceIssueDto dto) {
        String message;
        if (referenceIssues == null) {
            referenceIssues = loadReferenceIssueMessages();
        }
        if (referenceIssues.containsKey(identifier)) {
            message = referenceIssues.get(identifier);
            message = replaceStandardPlaceholders(dto, message);

        } else {
            message = getStandardReferenceIssueMessage(identifier, dto);
        }
        return message;
    }

    private String replaceStandardPlaceholders(ReferenceIssueDto dto, String message) {
        String msg = message.replace("%id%", dto.identifier);
        msg = msg.replace("%line%", Integer.toString(dto.line));
        return msg.replace("%pos%", Integer.toString(dto.position));
    }

    @Override
    public String getWrongArgumentTypeIssueMessage(String key, WrongArgumentTypeIssueDto dto) {
        String message;
        if (wrongArgumentTypeIssues == null) {
            wrongArgumentTypeIssues = loadWrongArgumentTypeIssueMessages();
        }
        if (wrongArgumentTypeIssues.containsKey(key)) {
            message = wrongArgumentTypeIssues.get(key);
            message = replaceStandardPlaceholders(dto, message);

            message = message.replace("%args%", getArguments(dto.actualParameterTypes));
            message = message.replace("%overloads%", getOverloadSignatures(dto.possibleOverloads));
        } else {
            message = getStandardWrongArgumentTypeIssueMessage(key, dto);
        }
        return message;
    }

    protected String getArguments(String[] arguments) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < arguments.length; ++i) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(arguments[i]);
        }
        sb.append(")");
        return sb.toString();
    }

    protected String getOverloadSignatures(List<MethodDto> overloads) {
        StringBuilder sb = new StringBuilder();
        Iterator<MethodDto> iterator = overloads.iterator();
        appendOverload(sb, iterator.next());
        while (iterator.hasNext()) {
            sb.append("\n");
            appendOverload(sb, iterator.next());
        }
        return sb.toString();
    }

    private void appendOverload(StringBuilder sb, MethodDto methodDto) {
        if (methodDto.typeParameters != null) {
            sb.append("[");
            Iterator<TypeParameterDto> iterator = methodDto.typeParameters.iterator();
            TypeParameterDto typeParameter = iterator.next();
            appendTypeParameter(sb, typeParameter);
            while (iterator.hasNext()) {
                sb.append(", ");
                typeParameter = iterator.next();
                appendTypeParameter(sb, typeParameter);
            }
            sb.append("]");
        }
        sb.append("(");
        Iterator<ParameterDto> iterator = methodDto.parameters.iterator();
        if (iterator.hasNext()) {
            appendParameter(sb, iterator.next());
        }
        while (iterator.hasNext()) {
            sb.append(", ");
            appendParameter(sb, iterator.next());
        }
        sb.append(")");
    }

    private void appendTypeParameter(StringBuilder sb, TypeParameterDto typeParameter) {
        if (typeParameter.lowerBound != null) {
            sb.append(typeParameter.lowerBound).append(" < ");
        }
        sb.append(typeParameter.typeVariable);
        if (typeParameter.upperBound != null) {
            sb.append(" < ").append(typeParameter.upperBound);
        }
    }

    private void appendParameter(StringBuilder sb, ParameterDto parameter) {
        sb.append(parameter.type.type);
        if (parameter.defaultValue != null) {
            sb.append("=").append(parameter.defaultValue);
        }
    }
}
