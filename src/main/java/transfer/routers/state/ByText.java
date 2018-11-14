package transfer.routers.state;

import dto.stateservisedto.StateResponseDTO;
import io.restassured.response.Response;
import transfer.BaseTransfer;

import transfer.Context;

public class ByText {
    private static final String ROUT = "/search/{param1}?text={param2}";
    private final BaseTransfer baseTransfer = new BaseTransfer();
    private final String path;

    public ByText(String parentRout) {
        this.path = parentRout + ROUT;
    }

    public Context<StateResponseDTO> get(String country, String text) {
        Response response = baseTransfer.get(path, country, text);
        return new Context<>(response, StateResponseDTO.class);
    }
}
