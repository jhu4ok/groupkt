package transfer.routers.state;

import dto.stateservisedto.StateResponseDTO;
import io.restassured.response.Response;
import transfer.BaseTransfer;
import transfer.Context;

public class ByCountryState {

    private static final String ROUT = "/get/{param1}/{param2}";
    private final BaseTransfer baseTransfer = new BaseTransfer();
    private final String path;

    public ByCountryState(String parentRout) {
        this.path = parentRout + ROUT;
    }

    public Context<StateResponseDTO> get(String country, String state) {
        Response response = baseTransfer.get(path, country, state);
        return new Context<>(response, StateResponseDTO.class);
    }

}
