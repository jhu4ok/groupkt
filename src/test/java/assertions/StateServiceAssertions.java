package assertions;


import dto.stateservisedto.StateResponseDTO;
import org.testng.Assert;
import util.PropertiesUtil;
import util.UrlConverter;


import java.util.Arrays;
import java.util.List;

public class StateServiceAssertions extends MainAssertions {


    public static void assertResponseContainsListOfAllStates(String expectedCount, StateResponseDTO stateResponseDTO) {
        Assert.assertEquals(Integer.parseInt(PropertiesUtil.getProp(expectedCount)),
                stateResponseDTO.getRestResponse().getResult().size(), "Incorrect States Count");
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

    public static void assertResponseMessageForStatesList(String expectedMessage, StateResponseDTO resultResponse, String resourceUrl, String value) {

        List<String> expectedMessageBuild;

        if (resultResponse.getRestResponse().getResult().size() > 0) {
            expectedMessageBuild = Arrays.asList(PropertiesUtil.
                    getProp(expectedMessage).replaceAll("TEXT", "[" + resultResponse.getRestResponse().getResult().size() + "]"));
            System.out.println(expectedMessageBuild);
        } else {
            String[] invalidURL = UrlConverter.splitResource(resourceUrl);
            expectedMessageBuild = Arrays.asList(PropertiesUtil
                    .getProp(expectedMessage).replaceAll("TEXT", "[" + invalidURL[2] + "->" + PropertiesUtil.getProp(value) + "]"));
        }

        Assert.assertEquals(expectedMessageBuild, resultResponse.getRestResponse().getMessages(), "Incorrect States List Response Message");
    }

    public void assertResponseMessageForState(String expectedMessage, StateResponseDTO stateResponseDTO, String resourseURL) {

        List<String> expectedMessageBuild;

        if (stateResponseDTO.getRestResponse().getResult() != null) {
            expectedMessageBuild = Arrays.asList(PropertiesUtil.getProp(expectedMessage).
                    replaceAll("TEXT", "[" + stateResponseDTO.getRestResponse().getResult().get(0).getAbbr() + "]"));

        } else {
            String[] uriReq = UrlConverter.splitResource(resourseURL);
            expectedMessageBuild = Arrays.asList(PropertiesUtil
                    .getProp(expectedMessage).replaceAll("TEXT", "[" + uriReq[2] + "->" + uriReq[3] + "]"));
        }
        Assert.assertEquals(expectedMessageBuild, stateResponseDTO.getRestResponse().getMessages(), "Incorrect States List Response Message");
    }
}

