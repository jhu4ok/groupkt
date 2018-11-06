//package assertions;
//
//import org.testng.Assert;
//import util.PropertiesUtil;
//import util.UrlConverter;
//
//
//import java.util.Arrays;
//import java.util.List;
//
//public class CountryServiceAssertions extends MainAssertions {
//
//    public void assertResponseMessageForCountriesList(String expectedMessage, CountriesResponseDTO resultResponse, String value) {
//
//        List<String> expectedMessageBuild;
//        if (resultResponse.getRestResponse().getResult().size() > 0) {
//            expectedMessageBuild = Arrays.
//                    asList(PropertiesUtil.
//                            getProp(expectedMessage).
//                            replaceAll("TEXT", "[" +
//                                    resultResponse.
//                                            getRestResponse().
//                                            getResult().
//                                            size() + "]"));
//        } else {
//            expectedMessageBuild = Arrays.
//                    asList(PropertiesUtil.
//                            getProp(expectedMessage).
//                            replaceAll("TEXT", "[" +
//                                    PropertiesUtil.getProp(value) + "]"));
//        }
//
//        Assert.assertEquals(expectedMessageBuild, resultResponse.getRestResponse().getMessages(), "Incorrect States List Response Message");
//    }
//
//    public void assertResponseContainsListOfAllCountries(String expectedCount, CountriesListResponseDTO resultResponse) {
//        Assert.assertEquals(Integer.parseInt(PropertiesUtil.getProp(expectedCount)), resultResponse.getRestResponse().getResult().size(), "Incorrect States Count");
//    }
//
//    public void assertResponseContainsCorrectCountryInfo(String expctedInfo, CountryResponseDTO countryResponseDTO) {
//        String[] uriReq = UrlConverter.splitResource(expctedInfo);
//        String code = uriReq[3];
//        if (uriReq[2].equals("iso2code")) {
//            Assert.assertEquals(code, countryResponseDTO.getRestResponse().getResult().getAlpha2_code(), "Incorrect alpha2_code");
//        } else {
//            Assert.assertEquals(code, countryResponseDTO.getRestResponse().getResult().getAlpha3_code(), "Incorrect alpha3_code");
//        }
//
//    }
//
//    public void assertResponseMessageForCountry(String expectedMessage, CountryResponseDTO countryResponseDTO, String resourseURL) {
//
//        List<String> expectedMessageBuild;
//        String[] uriReq = UrlConverter.splitResource(resourseURL);
//
//        if (countryResponseDTO.getRestResponse().getResult() != null && uriReq[2].equals("iso2code")) {
//
//            expectedMessageBuild = Arrays.
//                    asList(PropertiesUtil.
//                            getProp(expectedMessage).
//                            replaceAll("TEXT", "[" +
//                                    countryResponseDTO.getRestResponse().getResult().getAlpha2_code() + "]"));
//
//        } else if (countryResponseDTO.getRestResponse().getResult() != null && uriReq[2].equals("iso3code")) {
//
//            expectedMessageBuild = Arrays.asList(PropertiesUtil
//                    .getProp(expectedMessage).
//                            replaceAll("TEXT", "[" +
//                                    countryResponseDTO.getRestResponse().getResult().getAlpha3_code() + "]"));
//        } else {
//
//            expectedMessageBuild = Arrays.asList(PropertiesUtil
//                    .getProp(expectedMessage).
//                            replaceAll("TEXT", "[" +
//                                    uriReq[3] + "]"));
//        }
//        Assert.assertEquals(expectedMessageBuild, countryResponseDTO.getRestResponse().getMessages(), "Incorrect Country Response Message");
//    }
//
//
//}
