package transfer.countrytrans.routers.country;

import dto.countryservisedto.CountryResponseDTO;
import io.restassured.response.Response;
import transfer.Context;
import transfer.countrytrans.CountryTransfer;

public class GetAll {
    private static final String ROUT = "/get/all";
    private final CountryTransfer countryTransfer = new CountryTransfer();
    private final String path;

    public GetAll(String parentRout) {
        this.path = parentRout + ROUT;
    }

    public Context<CountryResponseDTO> get() {
        Response response = countryTransfer.getAll(path);
        return new Context<>(response, CountryResponseDTO.class);
    }
}
