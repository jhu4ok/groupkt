package steps;

import assertions.CountryServiceAssertions;
import dto.countryservisedto.CountryResponseDTO;

import org.apache.http.HttpStatus;
import transfer.Api;
import transfer.Context;

import util.GetObjectFromJsonUtil;
import transfer.routers.country.*;
import util.FileReaderUtil;

import java.io.BufferedReader;


public class StepsForCountryService {

    private final ByIsoCode searchByIsoCode = new Api().getCountry().getByIso3Code();
    private final ByText searchByText = new Api().getCountry().getByText();
    private final GetAll searchAll = new Api().getCountry().getGetAll();

    public void responseValidation(Context<CountryResponseDTO> context, String expectedResult) {

        CountryServiceAssertions.assertStatusCode(context.getResponseStatusCode(), HttpStatus.SC_OK);
        CountryServiceAssertions.assertObjectMessage(context.getObjectFromResponse(), getExpectedResult(expectedResult).getObjectFromFile());
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

    private GetObjectFromJsonUtil<CountryResponseDTO> getExpectedResult(String filePath) {
        BufferedReader reader = FileReaderUtil.readFile(filePath);
        return new GetObjectFromJsonUtil<>(reader, CountryResponseDTO.class);
    }
}
