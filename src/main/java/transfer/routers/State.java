package transfer.routers;

import lombok.Getter;
import transfer.BaseTransfer;
import transfer.routers.state.ByState;

public class State {
    private static final String ROUT = "/state";
    private final BaseTransfer baseTransfer = new BaseTransfer();
    private final String path;
    @Getter
    private final ByState byState;

    public State(String parentRout) {
        path = parentRout + ROUT;
        byState = new ByState(path);
    }

}
