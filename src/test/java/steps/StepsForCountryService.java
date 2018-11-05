package steps;

import dto.CountriesListResponseDTO;
import dto.CountryResponseDTO;
import io.restassured.response.Response;


public class StepsForCountryService extends MainSteps {

    public CountryResponseDTO convertResponseToCountryObject(Response response) {

        CountryResponseDTO countryResponseDTO = restRequestTransfer.objectRepresentationCountry(response);
        return countryResponseDTO;
    }

    public CountriesListResponseDTO convertResponseToCountriesListObject(Response response) {

        CountriesListResponseDTO countriesListResponseDTO = restRequestTransfer.objectRepresentationCountriesList(response);
        return countriesListResponseDTO;
    }
}
