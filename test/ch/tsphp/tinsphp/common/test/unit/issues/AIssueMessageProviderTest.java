/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.test.unit.issues;

import ch.tsphp.tinsphp.common.issues.AIssueMessageProvider;
import ch.tsphp.tinsphp.common.issues.DefinitionIssueDto;
import ch.tsphp.tinsphp.common.issues.ReferenceIssueDto;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class AIssueMessageProviderTest
{
    private final String standardDefinitionMessage = "dummy definition message";
    private final String standardReferenceMessage = "dummy reference message";

    private class ADummyMessageProvider extends AIssueMessageProvider
    {
        private final Map<String, String> definitionIssues;
        private final Map<String, String> referenceIssues;

        private int definitionCallCount = 0;
        private int referenceCallCount = 0;


        public ADummyMessageProvider(Map<String, String> theDefinitionIssues, Map<String, String> theReferenceIssues) {
            definitionIssues = theDefinitionIssues;
            referenceIssues = theReferenceIssues;
        }

        @Override
        public Map<String, String> loadDefinitionIssueMessages() {
            if (definitionCallCount > 1) {
                throw new RuntimeException();
            }
            ++definitionCallCount;
            return definitionIssues;
        }

        @Override
        public Map<String, String> loadReferenceIssueMessages() {
            if (referenceCallCount > 1) {
                throw new RuntimeException();
            }
            ++referenceCallCount;
            return referenceIssues;
        }

        @Override
        protected String getStandardDefinitionErrorMessage(String identifier, DefinitionIssueDto dto) {
            return standardDefinitionMessage;
        }

        @Override
        protected String getStandardReferenceErrorMessage(String identifier, ReferenceIssueDto dto) {
            return standardReferenceMessage;
        }
    }

    @Test
    public void getDefinitionErrorMessage_IdentifierExists_ReplacesIdLineAndPos() {
        Map<String, String> map = new HashMap<>();
        map.put("test", "id %id%, line %line%, pos %pos%, idN %idN%, lineN %lineN%, posN %posN%");
        String id = "id";
        int line = 12;
        int pos = 23;
        String idN = "newId";
        int lineN = 45;
        int posN = 89;
        DefinitionIssueDto dto = new DefinitionIssueDto(id, line, pos, idN, lineN, posN);

        AIssueMessageProvider messageProvider = createMessageProviderWithDefinitions(map);
        String result = messageProvider.getDefinitionErrorMessage("test", dto);

        assertThat(result, is("id , line " + line + ", pos " + pos
                + ", idN " + idN + ", lineN " + lineN + ", posN " + posN));
    }

    @Test
    public void getDefinitionErrorMessage_IdentifierDoesNotExist_ReturnsStandardDefinitionMessage() {
        Map<String, String> map = new HashMap<>();
        String id = "id";
        int line = 12;
        int pos = 23;
        String idN = "newId";
        int lineN = 45;
        int posN = 89;
        DefinitionIssueDto dto = new DefinitionIssueDto(id, line, pos, idN, lineN, posN);

        AIssueMessageProvider messageProvider = createMessageProviderWithDefinitions(map);
        String result = messageProvider.getDefinitionErrorMessage("test", dto);

        assertThat(result, is(standardDefinitionMessage));
    }

    @Test
    public void getDefinitionErrorMessage_CalledASecondTime_LoadMessagesOnlyOnce() {
        //no assert necessary

        AIssueMessageProvider messageProvider = createMessageProviderWithDefinitions(new HashMap<String, String>());
        messageProvider.getDefinitionErrorMessage("bla", mock(DefinitionIssueDto.class));
        messageProvider.getDefinitionErrorMessage("bli", mock(DefinitionIssueDto.class));

        //should not throw an exception
    }

    @Test
    public void getReferenceErrorMessage_IdentifierExists_ReplacesIdLineAndPos() {
        Map<String, String> map = new HashMap<>();
        map.put("test", "id %id%, line %line%, pos %pos%, idN %idN%, lineN %lineN%, posN %posN%");
        String id = "id";
        int line = 12;
        int pos = 23;
        ReferenceIssueDto dto = new ReferenceIssueDto(id, line, pos);

        AIssueMessageProvider messageProvider = createMessageProviderWithRefrence(map);
        String result = messageProvider.getReferenceErrorMessage("test", dto);

        assertThat(result, is("id " + id + ", line " + line + ", pos " + pos
                + ", idN %idN%, lineN %lineN%, posN %posN%"));
    }

    @Test
    public void getReferenceErrorMessage_IdentifierDoesNotExist_ReturnsStandardDefinitionMessage() {
        Map<String, String> map = new HashMap<>();
        String id = "id";
        int line = 12;
        int pos = 23;
        ReferenceIssueDto dto = new ReferenceIssueDto(id, line, pos);

        AIssueMessageProvider messageProvider = createMessageProviderWithRefrence(map);
        String result = messageProvider.getReferenceErrorMessage("test", dto);

        assertThat(result, is(standardReferenceMessage));
    }

    @Test
    public void getReferenceErrorMessage_CalledASecondTime_LoadMessagesOnlyOnce() {
        //no assert necessary

        AIssueMessageProvider messageProvider = createMessageProviderWithRefrence(new HashMap<String, String>());
        messageProvider.getReferenceErrorMessage("bla", mock(ReferenceIssueDto.class));
        messageProvider.getReferenceErrorMessage("bli", mock(ReferenceIssueDto.class));

        //should not throw an exception
    }

    private AIssueMessageProvider createMessageProviderWithDefinitions(Map<String, String> definitionIssueMessages) {
        return createMessageProvider(definitionIssueMessages, new HashMap<String, String>());
    }

    private AIssueMessageProvider createMessageProviderWithRefrence(Map<String, String> referenceIssueMessages) {
        return createMessageProvider(new HashMap<String, String>(), referenceIssueMessages);
    }

    protected AIssueMessageProvider createMessageProvider(
            Map<String, String> definitionIssues, Map<String, String> referenceIssues) {
        return new ADummyMessageProvider(definitionIssues, referenceIssues);
    }
}
