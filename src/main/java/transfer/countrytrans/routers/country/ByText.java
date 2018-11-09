package transfer.countrytrans.routers.country;

import dto.countryservisedto.CountryResponseDTO;
import io.restassured.response.Response;
import transfer.Context;
import transfer.countrytrans.CountryTransfer;


public class ByText {
    private static final String ROUT = "/search?text={text}";
    private final CountryTransfer countryTransfer = new CountryTransfer();
    private final String path;

    public ByText (String parentRout) {
        this.path = parentRout + ROUT;
    }

    public Context<CountryResponseDTO> get(String text) {
        Response response = countryTransfer.getByText(path, text);
        return new Context<>(response, CountryResponseDTO.class);
    }
}

