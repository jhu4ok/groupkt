package transfer.routers.country;

import dto.countryservisedto.CountryResponseDTO;
import io.restassured.response.Response;
import transfer.BaseTransfer;
import transfer.Context;


public class ByText {
    private static final String ROUT = "/search?text={param}";
    private final BaseTransfer countryTransfer = new BaseTransfer();
    private final String path;

    public ByText(String parentRout) {
        this.path = parentRout + ROUT;
    }

    public Context<CountryResponseDTO> get(String text) {
        Response response = countryTransfer.get(path, text);
        return new Context<>(response, CountryResponseDTO.class);
    }
}

