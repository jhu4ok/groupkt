package transfer.statetrans.routers.state;

        import dto.stateservisedto.StateResponseDTO;
        import io.restassured.response.Response;
        import transfer.statetrans.StateTransfer;
        import transfer.Context;

public class ByText {
    private static final String ROUT = "/search/{country}?text={text}";
    private final StateTransfer baseTransfer = new StateTransfer();
    private final String path;

    public ByText (String parentRout) {
        this.path = parentRout + ROUT;
    }

    public Context<StateResponseDTO> get(String country, String text) {
        Response response = baseTransfer.getByText(path, country, text);
        return new Context<>(response, StateResponseDTO.class);
    }
}
