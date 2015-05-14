/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.test.unit.issues;

import ch.tsphp.tinsphp.common.issues.AIssueMessageProvider;
import ch.tsphp.tinsphp.common.issues.DefinitionIssueDto;
import ch.tsphp.tinsphp.common.issues.ReferenceIssueDto;
import ch.tsphp.tinsphp.common.issues.WrongArgumentTypeIssueDto;
import ch.tsphp.tinsphp.common.translation.dtos.MethodDto;
import ch.tsphp.tinsphp.common.translation.dtos.ParameterDto;
import ch.tsphp.tinsphp.common.translation.dtos.TypeDto;
import ch.tsphp.tinsphp.common.translation.dtos.TypeParameterDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class AIssueMessageProviderTest
{
    private final String standardDefinitionMessage = "dummy definition message";
    private final String standardReferenceMessage = "dummy reference message";
    private final String standardWrongArgumentTypeMessage = "dummy wrong argument message";

    private class ADummyMessageProvider extends AIssueMessageProvider
    {
        private final Map<String, String> definitionIssues;
        private final Map<String, String> referenceIssues;
        private final Map<String, String> wrongArgumentTypeIssues;

        private int definitionCallCount = 0;
        private int referenceCallCount = 0;
        private int wrongArgumentCallCount = 0;


        public ADummyMessageProvider(
                Map<String, String> theDefinitionIssues,
                Map<String, String> theReferenceIssues,
                Map<String, String> theWrongArgumentTypeIssues) {
            definitionIssues = theDefinitionIssues;
            referenceIssues = theReferenceIssues;
            wrongArgumentTypeIssues = theWrongArgumentTypeIssues;
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
        protected Map<String, String> loadWrongArgumentTypeIssueMessages() {
            if (wrongArgumentCallCount > 1) {
                throw new RuntimeException();
            }
            ++wrongArgumentCallCount;
            return wrongArgumentTypeIssues;
        }

        @Override
        protected String getStandardDefinitionIssueMessage(String identifier, DefinitionIssueDto dto) {
            return standardDefinitionMessage;
        }

        @Override
        protected String getStandardReferenceIssueMessage(String identifier, ReferenceIssueDto dto) {
            return standardReferenceMessage;
        }

        @Override
        protected String getStandardWrongArgumentTypeIssueMessage(String identifier, WrongArgumentTypeIssueDto dto) {
            return standardWrongArgumentTypeMessage;
        }

    }

    @Test
    public void getDefinitionIssueMessage_IdentifierExists_ReplacesIdLineAndPos() {
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
        String result = messageProvider.getDefinitionIssueMessage("test", dto);

        assertThat(result, is("id , line " + line + ", pos " + pos
                + ", idN " + idN + ", lineN " + lineN + ", posN " + posN));
    }

    @Test
    public void getDefinitionIssueMessage_IdentifierDoesNotExist_ReturnsStandardDefinitionMessage() {
        Map<String, String> map = new HashMap<>();
        String id = "id";
        int line = 12;
        int pos = 23;
        String idN = "newId";
        int lineN = 45;
        int posN = 89;
        DefinitionIssueDto dto = new DefinitionIssueDto(id, line, pos, idN, lineN, posN);

        AIssueMessageProvider messageProvider = createMessageProviderWithDefinitions(map);
        String result = messageProvider.getDefinitionIssueMessage("test", dto);

        assertThat(result, is(standardDefinitionMessage));
    }

    @Test
    public void getDefinitionIssueMessage_CalledASecondTime_LoadMessagesOnlyOnce() {
        //no assert necessary

        AIssueMessageProvider messageProvider = createMessageProviderWithDefinitions(new HashMap<String, String>());
        messageProvider.getDefinitionIssueMessage("bla", mock(DefinitionIssueDto.class));
        messageProvider.getDefinitionIssueMessage("bli", mock(DefinitionIssueDto.class));

        //should not throw an exception
    }

    @Test
    public void getReferenceIssueMessage_IdentifierExists_ReplacesIdLineAndPos() {
        Map<String, String> map = new HashMap<>();
        map.put("test", "id %id%, line %line%, pos %pos%, idN %idN%, lineN %lineN%, posN %posN%");
        String id = "id";
        int line = 12;
        int pos = 23;
        ReferenceIssueDto dto = new ReferenceIssueDto(id, line, pos);

        AIssueMessageProvider messageProvider = createMessageProviderWithReference(map);
        String result = messageProvider.getReferenceIssueMessage("test", dto);

        assertThat(result, is("id " + id + ", line " + line + ", pos " + pos
                + ", idN %idN%, lineN %lineN%, posN %posN%"));
    }

    @Test
    public void getReferenceIssueMessage_IdentifierDoesNotExist_ReturnsStandardDefinitionMessage() {
        Map<String, String> map = new HashMap<>();
        String id = "id";
        int line = 12;
        int pos = 23;
        ReferenceIssueDto dto = new ReferenceIssueDto(id, line, pos);

        AIssueMessageProvider messageProvider = createMessageProviderWithReference(map);
        String result = messageProvider.getReferenceIssueMessage("test", dto);

        assertThat(result, is(standardReferenceMessage));
    }

    @Test
    public void getReferenceIssueMessage_CalledASecondTime_LoadMessagesOnlyOnce() {
        //no assert necessary

        AIssueMessageProvider messageProvider = createMessageProviderWithReference(new HashMap<String, String>());
        messageProvider.getReferenceIssueMessage("bla", mock(ReferenceIssueDto.class));
        messageProvider.getReferenceIssueMessage("bli", mock(ReferenceIssueDto.class));

        //should not throw an exception
    }

    @Test
    public void getWrongArgumentTypeIssueMessage_IdentifierExists_ReplacesIdLinePosArgumentAndListOfOverloads() {
        Map<String, String> map = new HashMap<>();
        map.put("test", "id %id%, line %line%, pos %pos%, idN %idN%, lineN %lineN%, posN %posN%\n"
                + "arguments\n%args%\noverloads:\n%overloads%");
        String id = "id";
        int line = 12;
        int pos = 23;
        ArrayList<MethodDto> overloads = new ArrayList<>();

        List<TypeParameterDto> typeParameters = asList(
                new TypeParameterDto(asList("T2", "int", "float"), "T1", null),
                new TypeParameterDto(asList("int"), "T2", asList("IA", "IB")));
        List<ParameterDto> parameters = asList(
                new ParameterDto(new TypeDto(null, "T1", null), null, null),
                new ParameterDto(new TypeDto(null, "int", null), null, null),
                new ParameterDto(new TypeDto(null, "T2", null), null, null)
        );
        overloads.add(new MethodDto(new TypeDto(null, "T1", null), null, typeParameters, parameters, null));

        typeParameters = asList(
                new TypeParameterDto(null, "T1", null),
                new TypeParameterDto(null, "T2", asList("int")));
        parameters = asList(
                new ParameterDto(new TypeDto(null, "T1", null), null, null),
                new ParameterDto(new TypeDto(null, "T2", null), null, null),
                new ParameterDto(new TypeDto(null, "string", null), null, null)
        );
        overloads.add(new MethodDto(new TypeDto(null, "int", null), null, typeParameters, parameters, null));

        typeParameters = asList(
                new TypeParameterDto(null, "T1", asList("num")),
                new TypeParameterDto(null, "T2", asList("int")));
        parameters = asList(
                new ParameterDto(new TypeDto(null, "T1", null), null, null),
                new ParameterDto(new TypeDto(null, "T2", null), null, null),
                new ParameterDto(new TypeDto(null, "string", null), null, null)
        );
        overloads.add(new MethodDto(new TypeDto(null, "int", null), null, typeParameters, parameters, null));

        parameters = asList(
                new ParameterDto(new TypeDto(null, "string", null), null, null),
                new ParameterDto(new TypeDto(null, "string", null), null, null),
                new ParameterDto(new TypeDto(null, "string", null), null, null)
        );
        overloads.add(new MethodDto(new TypeDto(null, "int", null), null, null, parameters, null));

        overloads.add(new MethodDto(new TypeDto(null, "int", null), null, null, new ArrayList<ParameterDto>(), null));

        WrongArgumentTypeIssueDto dto = new WrongArgumentTypeIssueDto(
                id, line, pos, new String[]{"int", "string", "float"}, overloads);

        AIssueMessageProvider messageProvider = createMessageProviderWithWrongArgumentType(map);
        String result = messageProvider.getWrongArgumentTypeIssueMessage("test", dto);

        assertThat(result, is("id " + id + ", line " + line + ", pos " + pos
                + ", idN %idN%, lineN %lineN%, posN %posN%\n"
                + "arguments\nint x string x float\noverloads:\n"
                + "T1 x int x T2 -> T1 \\ (T2 | int | float) < T1, int < T2 < (IA & IB)\n"
                + "T1 x T2 x string -> int \\ T2 < int\n"
                + "T1 x T2 x string -> int \\ T1 < num, T2 < int\n"
                + "string x string x string -> int\n"
                + "() -> int"));
    }

    @Test
    public void getWrongArgumentTypeMessage_IdentifierDoesNotExist_ReturnsStandardDefinitionMessage() {
        Map<String, String> map = new HashMap<>();
        String id = "id";
        int line = 12;
        int pos = 23;
        WrongArgumentTypeIssueDto dto = new WrongArgumentTypeIssueDto(
                id, line, pos, new String[]{}, new ArrayList<MethodDto>());

        AIssueMessageProvider messageProvider = createMessageProviderWithWrongArgumentType(map);
        String result = messageProvider.getWrongArgumentTypeIssueMessage("test", dto);

        assertThat(result, is(standardWrongArgumentTypeMessage));
    }

    @Test
    public void getWrongArgumentTypeIssueMessage_CalledASecondTime_LoadMessagesOnlyOnce() {
        //no assert necessary

        AIssueMessageProvider messageProvider = createMessageProviderWithWrongArgumentType(new HashMap<String,
                String>());
        messageProvider.getWrongArgumentTypeIssueMessage("bla", mock(WrongArgumentTypeIssueDto.class));
        messageProvider.getWrongArgumentTypeIssueMessage("bli", mock(WrongArgumentTypeIssueDto.class));

        //should not throw an exception
    }

    private AIssueMessageProvider createMessageProviderWithDefinitions(Map<String, String> definitionIssueMessages) {
        return createMessageProvider(
                definitionIssueMessages, new HashMap<String, String>(), new HashMap<String, String>());
    }

    private AIssueMessageProvider createMessageProviderWithReference(Map<String, String> referenceIssueMessages) {
        return createMessageProvider(
                new HashMap<String, String>(), referenceIssueMessages, new HashMap<String, String>());
    }

    private AIssueMessageProvider createMessageProviderWithWrongArgumentType(
            Map<String, String> wrongArgumentTypeIssueMessages) {
        return createMessageProvider(
                new HashMap<String, String>(), new HashMap<String, String>(), wrongArgumentTypeIssueMessages);
    }

    protected AIssueMessageProvider createMessageProvider(
            Map<String, String> definitionIssues,
            Map<String, String> referenceIssues,
            Map<String, String> wrongArgumentTypeIssues) {
        return new ADummyMessageProvider(definitionIssues, referenceIssues, wrongArgumentTypeIssues);
    }
}
