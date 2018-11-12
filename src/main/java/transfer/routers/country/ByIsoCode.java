package transfer.routers.country;

import dto.countryservisedto.CountryResponseDTO;
import io.restassured.response.Response;
import transfer.BaseTransfer;
import transfer.Context;

public class ByIsoCode {

    private static final String ROUT = "/get/{param1}/{param2}";
    private final BaseTransfer countryTransfer = new BaseTransfer();
    private final String path;

    public ByIsoCode(String parentRout) {
        this.path = parentRout + ROUT;
    }

    public Context<CountryResponseDTO> get(String code, String alphaCode) {
        Response response = countryTransfer.get(path, code, alphaCode);
        return new Context<>(response, CountryResponseDTO.class);
    }
}
