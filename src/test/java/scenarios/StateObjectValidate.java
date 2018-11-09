package scenarios;

import dto.stateservisedto.StateResponseDTO;
import org.testng.annotations.Test;
import steps.StepsForStateService;
import transfer.Context;


public class StateObjectValidate {


    private final StepsForStateService step = new StepsForStateService();


    @Test
    public void successGetAllStatesResponseNewVersion() {

        Context<StateResponseDTO> context = step.getStateByName("USA", "all");
        step.responseValidation(context, "src/test/java/expectedresults/state/resp_USA_all.json");
    }

    @Test
    public void getNothingMatchingFoundNewVersion() {

        Context<StateResponseDTO> context = step.getStateByName("USA", "al");
        step.responseValidation(context, "src/test/java/expectedresults/state/resp_USA_al.json");

    }

    @Test
    public void successGetOneStateResponse() {

        Context<StateResponseDTO> context = step.getStateByName("USA", "AK");
        step.responseValidation(context, "src/test/java/expectedresults/state/resp_USA_AK.json");
    }

    @Test
    public void getNothingMatchingFound() {

        Context<StateResponseDTO> context = step.getStateByName("USA", "al");
        step.responseValidation(context, "src/test/java/expectedresults/state/resp_USA_al.json");
    }


    @Test
    public void getStateByAnyFreeFormText() {
        Context<StateResponseDTO> context = step.getStateByText("USA", "wa");
        step.responseValidation(context, "src/test/java/expectedresults/state/resp_USA_text_wa.json");
    }

    @Test
    public void getNothingStateByAnyFreeFormText() {

        Context<StateResponseDTO> context = step.getStateByText("USA", "wj");
        step.responseValidation(context, "src/test/java/expectedresults/state/resp_USA_text_wj.json");
    }
}
