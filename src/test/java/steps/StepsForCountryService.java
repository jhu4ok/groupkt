package steps;

import assertions.CountryServiceAssertions;
import dto.countryservisedto.CountryResponseDTO;

import org.apache.http.HttpStatus;
import transfer.Api;
import transfer.Context;

import transfer.routers.country.*;


public class StepsForCountryService {

    private final ByIsoCode searchByIsoCode = new Api().getCountry().getByIso3Code();
    private final ByText searchByText = new Api().getCountry().getByText();
    private final GetAll searchAll = new Api().getCountry().getGetAll();
    private final FromFile expectedResult = new FromFile();

    public void responseValidation(Context<CountryResponseDTO> context, String expectedResult) {

        CountryServiceAssertions.assertStatusCode(context.getResponseStatusCode(), HttpStatus.SC_OK);
        CountryServiceAssertions.assertObjectMessage(context.getObjectFromResponse(), this.expectedResult.get(expectedResult).getObjectFromFile());
    }

    public Context<CountryResponseDTO> getCountryByIsoCode(String code, String alphaCode) {
        return searchByIsoCode.get(code, alphaCode);
    }

    public Context<CountryResponseDTO> getStateByText(String text) {
        return searchByText.get(text);
    }

    public Context<CountryResponseDTO> getAll() {
        return searchAll.get();
    }
}
