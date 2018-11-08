package transfer.routers.state;

import dto.stateservisedto.StateResponseDTO;
import io.restassured.response.Response;
import transfer.BaseTransfer;
import transfer.Context;

public class ByState {

    private static final String ROUT = "/get/USA/{state}";
    private final BaseTransfer baseTransfer = new BaseTransfer();
    private final String path;

    public ByState(String parentRout) {
        this.path = parentRout + ROUT;
    }

    public Context<StateResponseDTO> get(String state) {
        Response response = baseTransfer.getByState(path, state);
        return new Context<>(response, StateResponseDTO.class);
    }

}
