package assertions;

import dto.StateListResponseDTO;
import dto.StateResponseDTO;

import org.testng.Assert;
import util.PropertiesUtil;
import util.UrlConverter;


import java.util.Arrays;
import java.util.List;

public class StateServiceAssertions extends MainAssertions {


    public void assertResponseContainsListOfAllStates(String expectedCount, StateListResponseDTO resultResponse) {
        Assert.assertEquals(Integer.parseInt(PropertiesUtil.getProp(expectedCount)),
                resultResponse.getRestResponse().getResult().size(), "Incorrect States Count");
    }

    public void assertResponseContainsCorrectStateInfo(String expectedInfo, StateResponseDTO stateResponseDTO) {
        String[] uriReq = UrlConverter.splitResource(expectedInfo);
        String country = uriReq[2];
        String abbr = uriReq[3];

        Assert.assertEquals(country, stateResponseDTO.getRestResponse().getResult().getCountry(), "Incorrect States Country");
        Assert.assertEquals(abbr, stateResponseDTO.getRestResponse().getResult().getAbbr(), "Incorrect States Abbr");

    }


    public void assertResponseMessageForStatesList(String expectedMessage, StateListResponseDTO resultResponse, String resourseURL, String value) {

        List<String> expectedMessageBuild;

        if (resultResponse.getRestResponse().getResult().size() > 0) {
            expectedMessageBuild = Arrays.asList(PropertiesUtil.getProp(expectedMessage).replaceAll("TEXT", "[" + resultResponse.getRestResponse().getResult().size() + "]"));
        } else {
            String[] invalidURL = UrlConverter.splitResource(resourseURL);
            expectedMessageBuild = Arrays.asList(PropertiesUtil
                    .getProp(expectedMessage).replaceAll("TEXT", "[" + invalidURL[2] + "->" + PropertiesUtil.getProp(value) + "]"));
        }

        Assert.assertEquals(expectedMessageBuild, resultResponse.getRestResponse().getMessages(), "Incorrect States List Response Message");
    }

    public void assertResponseMessageForState(String expectedMessage, StateResponseDTO stateResponseDTO, String resourseURL) {

        List<String> expectedMessageBuild;

        if (stateResponseDTO.getRestResponse().getResult() != null) {
            expectedMessageBuild = Arrays.asList(PropertiesUtil.getProp(expectedMessage).replaceAll("TEXT", "[" + stateResponseDTO.getRestResponse().getResult().getAbbr() + "]"));

        } else {
            String[] uriReq = UrlConverter.splitResource(resourseURL);
            expectedMessageBuild = Arrays.asList(PropertiesUtil
                    .getProp(expectedMessage).replaceAll("TEXT", "[" + uriReq[2] + "->" + uriReq[3] + "]"));
        }
        Assert.assertEquals(expectedMessageBuild, stateResponseDTO.getRestResponse().getMessages(), "Incorrect States List Response Message");
    }


}
