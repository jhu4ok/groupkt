package assertions;


import dto.stateservisedto.StateResponseDTO;
import org.testng.Assert;
import util.PropertiesUtil;
import util.UrlConverter;


import java.util.Arrays;
import java.util.List;

public class StateServiceAssertions extends MainAssertions {

    public static final String MESSAGE_SUCCESS_STATE = "State found matching code TEXT.";
    public static final String MESSAGE_SUCCESS_LIST = "Total TEXT records found.";
    public static final String MESSAGE_NOTHING = "No matching state found for requested code TEXT.";

    public static final int NOTHING = 0;
    public static final int USA_STATES_COUNT = 55;
    public static final int COUNT_WA_STATES = 4;


    public static void assertResponseContainsListOfAllStates(int expectedCount, StateResponseDTO stateResponseDTO) {

        Assert.assertEquals(expectedCount, stateResponseDTO.getRestResponse().getResult().size(), "Incorrect States Count");
    }

    public void assertResponseContainsCorrectStateInfo(String expectedInfo, StateResponseDTO stateResponseDTO) {

        String[] uriReq = UrlConverter.splitResource(expectedInfo);
        String country = uriReq[2];
        String abbr = uriReq[3];

        Assert.assertEquals(country,
                stateResponseDTO.getRestResponse().getResult().get(0).getCountry(), "Incorrect States Country");
        Assert.assertEquals(abbr,
                stateResponseDTO.getRestResponse().getResult().get(0).getAbbr(), "Incorrect States Abbr");

    }

    public static void assertResponseMessage(String expectedMessage, StateResponseDTO resultResponse, String resourceUrl, String value) {

        List<String> expectedMessageBuild;

        if (resultResponse.getRestResponse().getResult() != null && resultResponse.getRestResponse().getResult().size() > 1) {
            expectedMessageBuild = Arrays.asList(expectedMessage.replaceAll("TEXT", "[" + resultResponse.getRestResponse().getResult().size() + "]"));
        } else if (resultResponse.getRestResponse().getResult() != null && resultResponse.getRestResponse().getResult().size() == 1) {
            expectedMessageBuild = Arrays.asList(expectedMessage.
                    replaceAll("TEXT", "[" + resultResponse.getRestResponse().getResult().get(0).getAbbr() + "]"));
        } else if (resultResponse.getRestResponse().getResult() == null) {
            String[] uriReq = UrlConverter.splitResource(resourceUrl);
            expectedMessageBuild = Arrays.asList(expectedMessage.replaceAll("TEXT", "[" + uriReq[2] + "->" + uriReq[3] + "]"));

        } else {
            String[] invalidURL = UrlConverter.splitResource(resourceUrl);
            expectedMessageBuild = Arrays.asList(expectedMessage.replaceAll("TEXT", "[" + invalidURL[2] + "->" + PropertiesUtil.getProp(value) + "]"));

        }

        Assert.assertEquals(expectedMessageBuild, resultResponse.getRestResponse().getMessages(), "Incorrect States List Response Message");
    }
}

