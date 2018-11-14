package assertions;

import dto.stateservisedto.StateResponseDTO;
import org.testng.Assert;


public class StateServiceAssertions extends MainAssertions {

    public static void assertObjectsMessage(StateResponseDTO state, StateResponseDTO expState) {
        Assert.assertEquals(state.getRestResponse().getMessages(), expState.getRestResponse().getMessages());
    }
}

