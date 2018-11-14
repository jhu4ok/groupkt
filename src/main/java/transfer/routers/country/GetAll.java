package transfer.routers.country;

import dto.countryservisedto.CountryResponseDTO;
import io.restassured.response.Response;
import transfer.BaseTransfer;
import transfer.Context;

public class GetAll {
    private static final String ROUT = "/get/all";
    private final BaseTransfer countryTransfer = new BaseTransfer();
    private final String path;

    public GetAll(String parentRout) {
        this.path = parentRout + ROUT;
    }

    public Context<CountryResponseDTO> get() {
        Response response = countryTransfer.get(path);
        return new Context<>(response, CountryResponseDTO.class);
    }
}
