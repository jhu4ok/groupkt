package steps;



import assertions.CountryServiceAssertions;
import dto.countryservisedto.CountryResponseDTO;

import org.apache.http.HttpStatus;
import transfer.Context;
import transfer.countrytrans.CountryApi;
import transfer.countrytrans.routers.country.*;





public class StepsForCountryService {

    private final ByIso2Code searchByIso2Code = new CountryApi().getCountry().getByIso2Code();
    private final ByIso3Code searchByIso3Code = new CountryApi().getCountry().getByIso3Code();
    private final ByText searchByText = new CountryApi().getCountry().getByText();
    private final GetAll searchAll = new CountryApi().getCountry().getGetAll();
    private final FromFile expectedResult = new FromFile();

    public void responseValidation(Context<CountryResponseDTO> context, String expectedResult){

        CountryServiceAssertions.assertStatusCode(context.getResponseStatusCode(), HttpStatus.SC_OK);
        CountryServiceAssertions.assertObjectMessage(context.getObjectFromResponse(), this.expectedResult.get(expectedResult).getObjectFromFile());
    }

    public Context<CountryResponseDTO> getCountryByIso2Code(String alpha2Code) {
        return searchByIso2Code.get(alpha2Code);
    }

    public Context<CountryResponseDTO> getCountryByIso3Code(String alpha3Code) {
        return searchByIso3Code.get(alpha3Code);
    }

    public Context<CountryResponseDTO> getStateByText(String text) {
        return searchByText.get(text);
    }
    public Context<CountryResponseDTO> getAll() {
        return searchAll.get();
    }
}
