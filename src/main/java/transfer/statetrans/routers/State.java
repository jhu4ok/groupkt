package transfer.statetrans.routers;

import lombok.Getter;
import transfer.statetrans.StateTransfer;
import transfer.statetrans.routers.state.ByCountryState;
import transfer.statetrans.routers.state.ByText;

public class State {
    private static final String ROUT = "/state";
    private final StateTransfer baseTransfer = new StateTransfer();
    private final String path;

    @Getter
    private final ByCountryState byState;
    @Getter
    private final ByText byText;

    public State(String parentRout) {
        path = parentRout + ROUT;
        byState = new ByCountryState(path);
        byText = new ByText(path);
    }
}
