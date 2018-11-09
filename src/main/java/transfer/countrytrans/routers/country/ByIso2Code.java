package transfer.countrytrans.routers.country;

import dto.countryservisedto.CountryResponseDTO;
import io.restassured.response.Response;
import transfer.Context;
import transfer.countrytrans.CountryTransfer;

public class ByIso2Code {

    private static final String ROUT = "/get/iso2code/{alpha2Code}";
    private final CountryTransfer countryTransfer = new CountryTransfer();
    private final String path;

    public ByIso2Code (String parentRout) {
        this.path = parentRout + ROUT;
    }

    public Context<CountryResponseDTO> get(String alpha2Code) {
        Response response = countryTransfer.getByIso2Code(path, alpha2Code);
        return new Context<>(response, CountryResponseDTO.class);
    }
}
