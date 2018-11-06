//package scenarios;
//
//import assertions.CountryServiceAssertions;
//
//
//import io.restassured.response.Response;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import steps.StepsForCountryService;
//
//public class CountryObjectValidate {
//
//    CountryServiceAssertions assertion = new CountryServiceAssertions();
//    StepsForCountryService step = new StepsForCountryService();
//
//
//    @BeforeMethod
//    public void setUp() {
//
//        step.initialiseBaseURI("HOST_COUNTRY");
//    }
//
//    @Test
//    public void successGetAllCountriesList() {
//
//        Response getResponse = step.sendGetRequest("ALL_COUNTRIES_RESOURCE");
//        CountriesListResponseDTO countriesListResponseDTO = step.convertResponseToCountriesListObject(getResponse);
//
//
//        assertion.assertStatusCode(getResponse, 200);
//        assertion.assertResponseMessageForCountriesList("MESSAGE_SUCCESS_LIST", countriesListResponseDTO, "");
//        assertion.assertResponseContainsListOfAllCountries("ALL_COUNTRIES_COUNT", countriesListResponseDTO);
//
//    }
//
//    @Test
//    public void getCountryByTwoCharISO() {
//        Response getResponse = step.sendGetRequest("ISO2CODE_RESOURCE");
//        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);
//
//        assertion.assertStatusCode(getResponse, 200);
//        assertion.assertResponseMessageForCountry("MESSAGE_SUCCESS_COUNTRY", countryResponseDTO, "ISO2CODE_RESOURCE");
//        assertion.assertResponseContainsCorrectCountryInfo("ISO2CODE_RESOURCE", countryResponseDTO);
//
//    }
//
//    @Test
//    public void getNothingMatchingFoundByTwoCharISO() {
//        Response getResponse = step.sendGetRequest("ISO2CODE_INVALID_RESOURCE");
//        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);
//
//        assertion.assertStatusCode(getResponse, 200);
//        assertion.assertResponseMessageForCountry("MESSAGE_NOTHING_COUNTRY", countryResponseDTO, "ISO2CODE_INVALID_RESOURCE");
//
//    }
//
//    @Test
//    public void getCountryByThreeCharISO() {
//        Response getResponse = step.sendGetRequest("ISO3CODE_RESOURCE");
//        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);
//
//        assertion.assertStatusCode(getResponse, 200);
//        assertion.assertResponseMessageForCountry("MESSAGE_SUCCESS_COUNTRY", countryResponseDTO, "ISO3CODE_RESOURCE");
//        assertion.assertResponseContainsCorrectCountryInfo("ISO3CODE_RESOURCE", countryResponseDTO);
//
//    }
//
//    @Test
//    public void getNothingMatchingFoundByThreeCharISO() {
//        Response getResponse = step.sendGetRequest("ISO3CODE_INVALID_RESOURCE");
//        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);
//
//
//        assertion.assertStatusCode(getResponse, 200);
//        assertion.assertResponseMessageForCountry("MESSAGE_NOTHING_COUNTRY", countryResponseDTO, "ISO3CODE_INVALID_RESOURCE");
//
//    }
//
//    @Test
//    public void getCountriesByAnyFreeFormText() {
//        Response getResponse = step.sendGetWithText("KEY_TEXT", "TEXT", "SEARCH_COUNTRY_RESOURCE");
//        CountriesListResponseDTO countriesListResponseDTO = step.convertResponseToCountriesListObject(getResponse);
//
//        assertion.assertStatusCode(getResponse, 200);
//        assertion.assertResponseMessageForCountriesList("MESSAGE_SUCCESS_LIST", countriesListResponseDTO, "TEXT");
//        assertion.assertResponseContainsListOfAllCountries("COUNT_WA_COUNTRIES", countriesListResponseDTO);
//
//    }
//
//    @Test
//    public void getNothingMatchingFoundByAnyFreeFormText() {
//        Response getResponse = step.sendGetWithText("KEY_TEXT", "INVALID_TEXT", "SEARCH_COUNTRY_RESOURCE");
//        CountriesListResponseDTO countriesListResponseDTO = step.convertResponseToCountriesListObject(getResponse);
//
//        assertion.assertStatusCode(getResponse, 200);
//        assertion.assertResponseMessageForCountriesList("MESSAGE_NOTHING_COUNTRY", countriesListResponseDTO, "INVALID_TEXT");
//        assertion.assertResponseContainsListOfAllCountries("NOTHING", countriesListResponseDTO);
//    }
//
//}
