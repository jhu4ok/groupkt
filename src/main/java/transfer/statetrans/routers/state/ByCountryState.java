package transfer.statetrans.routers.state;

import dto.stateservisedto.StateResponseDTO;
import io.restassured.response.Response;
import transfer.statetrans.StateTransfer;
import transfer.Context;

public class ByCountryState {

    private static final String ROUT = "/get/{country}/{state}";
    private final StateTransfer baseTransfer = new StateTransfer();
    private final String path;

    public ByCountryState(String parentRout) {
        this.path = parentRout + ROUT;
    }

    public Context<StateResponseDTO> get(String country, String state) {
        Response response = baseTransfer.getByCountryState(path, country, state);
        return new Context<>(response, StateResponseDTO.class);
    }

}
