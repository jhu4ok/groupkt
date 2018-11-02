package assertions;

import dto.StateListResponseDTO;
import dto.StateResponseDTO;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class GetResponseAssertions {


    int id = 2;
    String country = "USA";
    String name = "Alaska";
    String abbr = "AK";
    String area = "1723337SKM";
    String largest_city = "Anchorage";
    String capital = "Juneau";


    public void assertResponseContainsListOfAllCountries(int expectedCount, StateListResponseDTO resultResponse) {

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

    public void assertStatusCode(Response response, int expectedStatusCode) {

        int actualStatusCode = response.statusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Incorrect Status Code");
    }

    public void assertResponseMessageForStatesList(StateListResponseDTO resultResponse) {

        List<String> expectedMessage = Arrays.asList("Total [" + resultResponse.getRestResponse().getResult().size() + "] records found.");
        Assert.assertEquals(expectedMessage, resultResponse.getRestResponse().getMessages(), "Incorrect States List Response Message");
    }

    public void assertResponseMessageForState(StateResponseDTO stateResponseDTO) {

        List<String> expectedMessage = Arrays.asList("State found matching code [" + stateResponseDTO.getRestResponse().getResult().getAbbr() + "].");
        Assert.assertEquals(expectedMessage, stateResponseDTO.getRestResponse().getMessages(), "Incorrect States List Response Message");
    }

    public void assertFalseResponseMessage(StateResponseDTO resultResponse, String wrongResourseURL) {

        String[] uriReq = wrongResourseURL.split("/");
        List<String> expectedMessage = Arrays.asList("No matching state found for requested code [" + uriReq[2] + "->" + uriReq[3] + "].");
        Assert.assertEquals(expectedMessage, resultResponse.getRestResponse().getMessages(), "Incorrect States List Response Message");
    }
}
