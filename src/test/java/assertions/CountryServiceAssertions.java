package assertions;

import dto.CountriesListResponseDTO;
import dto.CountryResponseDTO;
import org.testng.Assert;


import java.util.Arrays;
import java.util.List;

public class CountryServiceAssertions extends MainAssertions {

    String name = "Ukraine";
    String alpha2_code = "UA";
    String alpha3_code = "UKR";

    public void assertResponseMessageForCountriesList(String expMsg, CountriesListResponseDTO resultResponse, String value) {
        List<String> expectedMessage;


        if (resultResponse.getRestResponse().getResult().size() > 0) {
            expectedMessage = Arrays.asList(expMsg + resultResponse.getRestResponse().getResult().size() + "] records found.");
        } else {
            expectedMessage = Arrays.asList(expMsg + value + "].");
        }

        Assert.assertEquals(expectedMessage, resultResponse.getRestResponse().getMessages(), "Incorrect States List Response Message");
    }

    public void assertResponseContainsListOfAllCountries(int expectedCount, CountriesListResponseDTO resultResponse) {
        Assert.assertEquals(expectedCount, resultResponse.getRestResponse().getResult().size(), "Incorrect States Count");
    }

    public void assertResponseContainsCorrectCountryInfo(CountryResponseDTO countryResponseDTO) {

        Assert.assertEquals(name, countryResponseDTO.getRestResponse().getResult().getName(), "Incorrect Country Name");
        Assert.assertEquals(alpha2_code, countryResponseDTO.getRestResponse().getResult().getAlpha2_code(), "Incorrect alpha2_code");
        Assert.assertEquals(alpha3_code, countryResponseDTO.getRestResponse().getResult().getAlpha3_code(), "Incorrect alpha3_code");

    }

    public void assertResponseMessageForCountry(String expected, CountryResponseDTO countryResponseDTO, String resourseURL) {

        List<String> expectedMessage;
        String[] uriReq = resourseURL.split("/");

        if (countryResponseDTO.getRestResponse().getResult() != null && uriReq[2].equals("iso2code")) {

            expectedMessage = Arrays.asList(expected + countryResponseDTO.getRestResponse().getResult().getAlpha2_code() + "].");

        } else if (countryResponseDTO.getRestResponse().getResult() != null && uriReq[2].equals("iso3code")) {
            expectedMessage = Arrays.asList(expected + countryResponseDTO.getRestResponse().getResult().getAlpha3_code() + "].");
        } else {

            expectedMessage = Arrays.asList(expected + uriReq[3] + "].");
        }

        Assert.assertEquals(expectedMessage, countryResponseDTO.getRestResponse().getMessages(), "Incorrect Country Response Message");

    }


}
