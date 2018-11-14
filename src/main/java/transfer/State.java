package transfer;

import lombok.Getter;
import transfer.routers.state.ByCountryState;
import transfer.routers.state.ByText;

public class State {
    private static final String ROUT = "/state";
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
