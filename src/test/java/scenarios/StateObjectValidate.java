package scenarios;

import dto.stateservisedto.StateResponseDTO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.StepsForStateService;
import transfer.Context;


public class StateObjectValidate {


    private final StepsForStateService step = new StepsForStateService();

    @Test(dataProvider = "statesAll")
    public void successGetAllStatesResponse(String country, String expectedResult) {

        Context<StateResponseDTO> context = step.getStateByName(country, "all");
        step.responseValidation(context, expectedResult);
    }

    @Test(dataProvider = "stateNothing")
    public void getNothingMatchingFound(String country, String state, String expectedResult) {

        Context<StateResponseDTO> context = step.getStateByName(country, state);
        step.responseValidation(context, expectedResult);

    }

    @Test(dataProvider = "successOneState")
    public void successGetOneStateResponse(String country, String state, String expectedResult) {

        Context<StateResponseDTO> context = step.getStateByName(country, state);
        step.responseValidation(context, expectedResult);
    }

    @Test(dataProvider = "textSearch")
    public void getStateByAnyFreeFormText(String country, String text, String expectedResult) {
        Context<StateResponseDTO> context = step.getStateByText(country, text);
        step.responseValidation(context, expectedResult);
    }

    @Test(dataProvider = "textSearchNothing")
    public void getNothingStateByAnyFreeFormText(String country, String text, String expectedResult) {

        Context<StateResponseDTO> context = step.getStateByText(country, text);
        step.responseValidation(context, expectedResult);
    }

    @DataProvider
    public static Object[][] statesAll() {
        return new Object[][]{
                {"USA", "src/test/java/expectedresults/state/resp_USA_all.json"},
                {"IND", "src/test/java/expectedresults/state/resp_IND_all.json"},
                {"UKR", "src/test/java/expectedresults/state/resp_UKR_all.json"}
        };
    }

    @DataProvider
    public static Object[][] stateNothing() {
        return new Object[][]{
                {"USA", "al", "src/test/java/expectedresults/state/resp_USA_al.json"},
                {"USA", "ak", "src/test/java/expectedresults/state/resp_USA_ak_no.json"},
                {"IND", "AK", "src/test/java/expectedresults/state/resp_IND_AK.json"}
        };
    }

    @DataProvider
    public static Object[][] successOneState() {
        return new Object[][]{
                {"USA", "AK", "src/test/java/expectedresults/state/resp_USA_AK.json"},
                {"IND", "AP", "src/test/java/expectedresults/state/resp_IND_AP.json"},
                {"USA", "WA", "src/test/java/expectedresults/state/resp_USA_WA.json"}
        };
    }

    @DataProvider
    public static Object[][] textSearch() {
        return new Object[][]{
                {"USA", "wa", "src/test/java/expectedresults/state/resp_USA_text_wa.json"},
                {"USA", "se", "src/test/java/expectedresults/state/resp_USA_text_se.json"},
                {"IND", "ra", "src/test/java/expectedresults/state/resp_IND_text_ra.json"}
        };
    }

    @DataProvider
    public static Object[][] textSearchNothing() {
        return new Object[][]{
                {"USA", "wj", "src/test/java/expectedresults/state/resp_USA_text_wj.json"},
                {"ind", "rp", "src/test/java/expectedresults/state/resp_IND_rp.json"},
                {"usa", "sea", "src/test/java/expectedresults/state/resp_USA_sea.json"}
        };
    }

}
