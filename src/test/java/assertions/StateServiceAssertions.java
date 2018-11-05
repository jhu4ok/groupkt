package assertions;

import dto.StateListResponseDTO;
import dto.StateResponseDTO;

import io.restassured.response.Response;
import org.testng.Assert;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class StateServiceAssertions extends MainAssertions {


    int id = 2;
    String country = "USA";
    String name = "Alaska";
    String abbr = "AK";
    String area = "1723337SKM";
    String largest_city = "Anchorage";
    String capital = "Juneau";


    public void assertResponseContainsListOfAllStates(int expectedCount, StateListResponseDTO resultResponse) {
        Assert.assertEquals(expectedCount, resultResponse.getRestResponse().getResult().size(), "Incorrect States Count");
    }

    public void assertResponseContainsCorrectStateInfo(StateResponseDTO stateResponseDTO) {

        Assert.assertEquals(id, stateResponseDTO.getRestResponse().getResult().getId(), "Incorrect States Id");
        Assert.assertEquals(country, stateResponseDTO.getRestResponse().getResult().getCountry(), "Incorrect States Country");
        Assert.assertEquals(name, stateResponseDTO.getRestResponse().getResult().getName(), "Incorrect States Name");
        Assert.assertEquals(abbr, stateResponseDTO.getRestResponse().getResult().getAbbr(), "Incorrect States Abbr");
        Assert.assertEquals(area, stateResponseDTO.getRestResponse().getResult().getArea(), "Incorrect States Area");
        Assert.assertEquals(largest_city, stateResponseDTO.getRestResponse().getResult().getLargest_city(), "Incorrect States Largest City");
        Assert.assertEquals(capital, stateResponseDTO.getRestResponse().getResult().getCapital(), "Incorrect States Capital");
    }

    public void assertResponseMessageForStatesList(String expMsg, StateListResponseDTO resultResponse, String resourseURL, String value) {
        List<String> expectedMessage;


        if (resultResponse.getRestResponse().getResult().size() > 0) {
            expectedMessage = Arrays.asList(expMsg + resultResponse.getRestResponse().getResult().size() + "] records found.");
        } else {
            String[] uriReq = resourseURL.split("/");
            expectedMessage = Arrays.asList(expMsg + uriReq[2] + "->" + value + "].");
        }

        Assert.assertEquals(expectedMessage, resultResponse.getRestResponse().getMessages(), "Incorrect States List Response Message");
    }

    public void assertResponseMessageForState(String expMess, StateResponseDTO stateResponseDTO, String resourseURL) {

        List<String> expectedMessage;

        if (stateResponseDTO.getRestResponse().getResult() != null) {

            expectedMessage = Arrays.asList(expMess + stateResponseDTO.getRestResponse().getResult().getAbbr() + "].");

        } else {

            String[] uriReq = resourseURL.split("/");
            expectedMessage = Arrays.asList(expMess + uriReq[2] + "->" + uriReq[3] + "].");
        }

        Assert.assertEquals(expectedMessage, stateResponseDTO.getRestResponse().getMessages(), "Incorrect States List Response Message");
    }

public void assertResponseContainsCorrectInfo(StateListResponseDTO resultResponse, String state){
   resultResponse.getRestResponse().getResult().stream().count();
//            allMatch((country -> state.equals(resultResponse.getRestResponse().getResult()))));
//    Collection<HashMap<String, ?>> resultMap =  resp.path("RestResponse.result");
//    Assert.assertTrue(!resultResponse.getRestResponse().getResult().stream().
//            allMatch(s -> s.getRestResponse().getResult().toString().isEmpty()));

//    Assert.assertTrue(!resultMap.stream().allMatch(s -> s.get(“location”).toString().isEmpty()));
}

}
