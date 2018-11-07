package assertions;

import dto.countryservisedto.CountryResponseDTO;
import org.testng.Assert;
import util.PropertiesUtil;
import util.UrlConverter;


import java.util.Arrays;
import java.util.List;

public class CountryServiceAssertions extends MainAssertions {

    public static final String MESSAGE_NOTHING = "No matching country found for requested code TEXT.";
    public static final String MESSAGE_SUCCESS_COUNTRY = "Country found matching code TEXT.";
    public static final String MESSAGE_SUCCESS_LIST = "Total TEXT records found.";

    public static final int NOTHING = 0;
    public static final int COUNT_WA_COUNTRIES = 7;
    public static final int ALL_COUNTRIES_COUNT = 249;

    public static void assertResponseMessage(String expectedMessage, CountryResponseDTO resultResponse, String resourseURL, String value) {

        List<String> expectedMessageBuild;
        String[] uriReq = UrlConverter.splitResource(resourseURL);
        if (resultResponse.getRestResponse().getResult() != null && resultResponse.getRestResponse().getResult().size() > 1) {

            expectedMessageBuild = Arrays.
                    asList(expectedMessage.
                            replaceAll("TEXT", "[" +
                                    resultResponse.
                                            getRestResponse().
                                            getResult().
                                            size() + "]"));
        } else if (resultResponse.getRestResponse().getResult() != null && resultResponse.getRestResponse().getResult().size() > 1 && uriReq[2].equals("iso2code")) {

            expectedMessageBuild = Arrays.
                    asList(expectedMessage.
                            replaceAll("TEXT", "[" +
                                    resultResponse.getRestResponse().getResult().get(0).getAlpha2_code() + "]"));
        } else if (resultResponse.getRestResponse().getResult() != null && resultResponse.getRestResponse().getResult().size() > 1 && uriReq[2].equals("iso3code")) {

            expectedMessageBuild = Arrays.asList(expectedMessage.
                    replaceAll("TEXT", "[" +
                            resultResponse.getRestResponse().getResult().get(0).getAlpha3_code() + "]"));
        } else if (value == null) {

            expectedMessageBuild = Arrays.asList(expectedMessage.
                    replaceAll("TEXT", "[" +
                            uriReq[3] + "]"));
        } else {

            expectedMessageBuild = Arrays.
                    asList(expectedMessage.
                            replaceAll("TEXT", "[" +
                                    PropertiesUtil.getProp(value) + "]"));
        }

        Assert.assertEquals(expectedMessageBuild, resultResponse.getRestResponse().

                getMessages(), "Incorrect States List Response Message");
    }

    public void assertResponseContainsListOfAllCountries(int expectedCount, CountryResponseDTO resultResponse) {

        Assert.assertEquals(expectedCount, resultResponse.getRestResponse().getResult().size(), "Incorrect States Count");
    }

    public void assertResponseContainsCorrectCountryInfo(String expctedInfo, CountryResponseDTO countryResponseDTO) {

        String[] uriReq = UrlConverter.splitResource(expctedInfo);
        String code = uriReq[3];
        if (uriReq[2].equals("iso2code")) {
            Assert.assertEquals(code, countryResponseDTO.getRestResponse().getResult().get(0).getAlpha2_code(), "Incorrect alpha2_code");
        } else {
            Assert.assertEquals(code, countryResponseDTO.getRestResponse().getResult().get(0).getAlpha3_code(), "Incorrect alpha3_code");
        }
    }
}
