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

    protected abstract Map<String, String> loadDefinitionIssueMessages();

    protected abstract Map<String, String> loadReferenceIssueMessages();

    protected abstract String getStandardDefinitionErrorMessage(String identifier, DefinitionIssueDto dto);

    protected abstract String getStandardReferenceErrorMessage(String identifier, ReferenceIssueDto dto);


    @Override
    public String getDefinitionErrorMessage(String identifier, DefinitionIssueDto dto) {
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
            message = getStandardDefinitionErrorMessage(identifier, dto);
        }
        return message;
    }

    @Override
    public String getReferenceErrorMessage(String identifier, ReferenceIssueDto dto) {
        String message;
        if (referenceIssues == null) {
            referenceIssues = loadReferenceIssueMessages();
        }
        if (referenceIssues.containsKey(identifier)) {
            message = referenceIssues.get(identifier);
            message = replaceStandardPlaceholders(dto, message);

        } else {
            message = getStandardReferenceErrorMessage(identifier, dto);
        }
        return message;
    }

    private String replaceStandardPlaceholders(ReferenceIssueDto dto, String message) {
        String msg = message.replace("%id%", dto.identifier);
        msg = msg.replace("%line%", Integer.toString(dto.line));
        return msg.replace("%pos%", Integer.toString(dto.position));
    }
}
