package transfer;

import dto.countryservisedto.CountryResponseDTO;
import io.restassured.response.Response;


public class CountryResponseTransfer extends MainResponseTransfer {

    public static CountryResponseDTO countryObjectRepresentation(Response response) {

        String stringResponse = parseResponseToString(response);
        CountryResponseDTO countryResponseDTO = createGsonObject().fromJson(stringResponse, CountryResponseDTO.class);
        return countryResponseDTO;
    }
}
