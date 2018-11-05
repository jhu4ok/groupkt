package scenarios;

import assertions.CountryServiceAssertions;

import dto.CountriesListResponseDTO;
import dto.CountryResponseDTO;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.StepsForCountryService;


public class CountryObjectValidate {

    CountryServiceAssertions assertion = new CountryServiceAssertions();
    StepsForCountryService step = new StepsForCountryService();
    String expectedMessageSuccess = "Country found matching code [";
    String expectedMessageNothing = "No matching country found for requested code [";
    String expectedMessageSuccessForList = "Total [";
    String expectedMessageNothingForList = "No matching country found for requested code [";

    @BeforeMethod
    public void setUp() {

        step.initialiseBaseURI("HOST_COUNTRY");

    }

    @Test
    public void successGetAllCountriesList() {

        Response getResponse = step.sendGetRequest("/get/all");
        CountriesListResponseDTO countriesListResponseDTO = step.convertResponseToCountriesListObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForCountriesList(expectedMessageSuccessForList, countriesListResponseDTO, "");
        assertion.assertResponseContainsListOfAllCountries(249, countriesListResponseDTO);

    }

    @Test
    public void getCountryByTwoCharISO() {
        Response getResponse = step.sendGetRequest("/get/iso2code/UA");
        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForCountry(expectedMessageSuccess, countryResponseDTO, "/get/iso2code/UA");
        assertion.assertResponseContainsCorrectCountryInfo(countryResponseDTO);

    }

    @Test
    public void getNothingMatchingFoundByTwoCharISO() {
        Response getResponse = step.sendGetRequest("/get/iso2code/UJ");
        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForCountry(expectedMessageNothing, countryResponseDTO, "/get/iso2code/UJ");

    }

    @Test
    public void getCountryByThreeCharISO() {
        Response getResponse = step.sendGetRequest("/get/iso3code/UKR");
        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForCountry(expectedMessageSuccess, countryResponseDTO, "/get/iso3code/UKR");
        assertion.assertResponseContainsCorrectCountryInfo(countryResponseDTO);

    }

    @Test
    public void getNothingMatchingFoundByThreeCharISO() {
        Response getResponse = step.sendGetRequest("/get/iso3code/UKJ");
        CountryResponseDTO countryResponseDTO = step.convertResponseToCountryObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForCountry(expectedMessageNothing, countryResponseDTO, "/get/iso3code/UKJ");

    }

    @Test
    public void getCountriesByAnyFreeFormText() {
        Response getResponse = step.sendGetWithText("text", "ua", "/search");
        CountriesListResponseDTO countriesListResponseDTO = step.convertResponseToCountriesListObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForCountriesList(expectedMessageSuccessForList, countriesListResponseDTO, "ua");
        assertion.assertResponseContainsListOfAllCountries(13, countriesListResponseDTO);

    }

    @Test
    public void getNothingMatchingFoundByAnyFreeFormText() {
        Response getResponse = step.sendGetWithText("text", "uj", "/search");
        CountriesListResponseDTO countriesListResponseDTO = step.convertResponseToCountriesListObject(getResponse);

        assertion.assertStatusCode(getResponse, 200);
        assertion.assertResponseMessageForCountriesList(expectedMessageNothingForList, countriesListResponseDTO, "uj");
        assertion.assertResponseContainsListOfAllCountries(0, countriesListResponseDTO);
    }

}
