package steps;

import assertions.CountryServiceAssertions;
import dto.countryservisedto.CountryResponseDTO;
import io.restassured.response.Response;

import org.apache.http.HttpStatus;
import transfer.CountryResponseTransfer;

public class StepsForCountryService extends MainSteps {

    public CountryResponseDTO convertResponseToCountryObject(Response response) {

        CountryResponseDTO countryResponseDTO = CountryResponseTransfer.countryObjectRepresentation(response);
        return countryResponseDTO;
    }

    public void basicResponseAssertion(Response getResponse, String expectedMessage, CountryResponseDTO countryResponseDTO, String resourseURL, String value) {

        CountryServiceAssertions.assertStatusCode(getResponse, HttpStatus.SC_OK);
        CountryServiceAssertions.assertResponseMessage(expectedMessage, countryResponseDTO,  resourseURL, value);
    }
}
