package transfer.countrytrans.routers.country;

import dto.countryservisedto.CountryResponseDTO;
import io.restassured.response.Response;
import transfer.Context;
import transfer.countrytrans.CountryTransfer;

public class ByIso3Code {

    private static final String ROUT = "/get/iso3code/{alpha3Code}";
    private final CountryTransfer countryTransfer = new CountryTransfer();
    private final String path;

    public ByIso3Code (String parentRout) {
        this.path = parentRout + ROUT;
    }

    public Context<CountryResponseDTO> get(String text) {
        Response response = countryTransfer.getByIso3Code(path, text);
        return new Context<>(response, CountryResponseDTO.class);
    }
}
