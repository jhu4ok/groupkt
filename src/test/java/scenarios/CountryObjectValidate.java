package scenarios;

import assertions.CountryServiceAssertions;


import dto.countryservisedto.CountryResponseDTO;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.StepsForCountryService;


public class CountryObjectValidate {

    CountryServiceAssertions assertion = new CountryServiceAssertions();
    StepsForCountryService step = new StepsForCountryService();


    @BeforeMethod
    public void setUp() {

        step.initialiseBaseURI("HOST_COUNTRY");
    }



    @Test
    public void successGetAllCountriesList() {

        Response getResponse = step.sendGetRequest("ALL_COUNTRIES_RESOURCE");
        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);

        step.basicResponseAssertion(getResponse, CountryServiceAssertions.MESSAGE_SUCCESS_LIST, countryResponseDTO, "ALL_COUNTRIES_RESOURCE", null);
        assertion.assertResponseContainsListOfAllCountries(CountryServiceAssertions.ALL_COUNTRIES_COUNT, countryResponseDTO);
    }

    @Test
    public void getCountryByTwoCharISO() {

        Response getResponse = step.sendGetRequest("ISO2CODE_RESOURCE");
        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);

        step.basicResponseAssertion(getResponse, CountryServiceAssertions.MESSAGE_SUCCESS_COUNTRY, countryResponseDTO, "ISO2CODE_RESOURCE", null);
        assertion.assertResponseContainsCorrectCountryInfo("ISO2CODE_RESOURCE", countryResponseDTO);
    }

    @Test
    public void getNothingMatchingFoundByTwoCharISO() {

        Response getResponse = step.sendGetRequest("ISO2CODE_INVALID_RESOURCE");
        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);

        step.basicResponseAssertion(getResponse, CountryServiceAssertions.MESSAGE_NOTHING, countryResponseDTO, "ISO2CODE_INVALID_RESOURCE", null);
    }

    @Test
    public void getCountryByThreeCharISO() {

        Response getResponse = step.sendGetRequest("ISO3CODE_RESOURCE");
        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);

        step.basicResponseAssertion(getResponse, CountryServiceAssertions.MESSAGE_SUCCESS_COUNTRY, countryResponseDTO, "ISO3CODE_RESOURCE", null);
        assertion.assertResponseContainsCorrectCountryInfo("ISO3CODE_RESOURCE", countryResponseDTO);
    }

    @Test
    public void getNothingMatchingFoundByThreeCharISO() {

        Response getResponse = step.sendGetRequest("ISO3CODE_INVALID_RESOURCE");
        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);

        step.basicResponseAssertion(getResponse, CountryServiceAssertions.MESSAGE_NOTHING, countryResponseDTO, "ISO3CODE_INVALID_RESOURCE", null);
    }

    @Test
    public void getCountriesByAnyFreeFormText() {

        Response getResponse = step.sendGetWithText("KEY_TEXT", "TEXT", "SEARCH_COUNTRY_RESOURCE");
        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);

        step.basicResponseAssertion(getResponse, CountryServiceAssertions.MESSAGE_SUCCESS_LIST, countryResponseDTO, "SEARCH_COUNTRY_RESOURCE", "TEXT");
        assertion.assertResponseContainsListOfAllCountries(CountryServiceAssertions.COUNT_WA_COUNTRIES, countryResponseDTO);
    }

    @Test
    public void getNothingMatchingFoundByAnyFreeFormText() {

        Response getResponse = step.sendGetWithText("KEY_TEXT", "INVALID_TEXT", "SEARCH_COUNTRY_RESOURCE");
        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);

        step.basicResponseAssertion(getResponse, CountryServiceAssertions.MESSAGE_NOTHING, countryResponseDTO, "SEARCH_COUNTRY_RESOURCE", "INVALID_TEXT");
        assertion.assertResponseContainsListOfAllCountries(CountryServiceAssertions.NOTHING, countryResponseDTO);
    }

}
