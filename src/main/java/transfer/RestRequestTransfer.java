package transfer;

import dto.CountriesListResponseDTO;
import dto.CountryResponseDTO;
import dto.StateListResponseDTO;
import dto.StateResponseDTO;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


public class RestRequestTransfer {


    public StateListResponseDTO objectRepresentationStateList(Response response) {
        ResponseBody body = response.getBody();
        StateListResponseDTO stateListResponseDTO = body.as(StateListResponseDTO.class);
        return stateListResponseDTO;
    }

    public StateResponseDTO objectRepresentationState(Response response) {
        ResponseBody body = response.getBody();
        StateResponseDTO stateResponseDTO = body.as(StateResponseDTO.class);
        return stateResponseDTO;
    }

    public CountriesListResponseDTO objectRepresentationCountriesList(Response response) {
        ResponseBody body = response.getBody();
        CountriesListResponseDTO countriesListResponseDTO = body.as(CountriesListResponseDTO.class);
        return countriesListResponseDTO;
    }

    public CountryResponseDTO objectRepresentationCountry(Response response) {
        ResponseBody body = response.getBody();
        CountryResponseDTO countryResponseDTO = body.as(CountryResponseDTO.class);
        return countryResponseDTO;
    }

    public Response getRequest(String url) {
        Response response =
                get(url).
                        then().
                        extract().response();
        return response;
    }

    public Response getRequestUsingText(String key, String value, String url) {
        Response response =
                given().
                        param(key, value).
                        get(url).
                        then().
                        extract().response();
        return response;
    }
}
