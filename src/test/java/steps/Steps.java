package steps;

import dto.StateListResponseDTO;
import dto.StateResponseDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import transfer.RestResponseConverter;
import util.PropertiesUtil;


public class Steps {
    private RestResponseConverter restResponseConverter = new RestResponseConverter();


    public StateResponseDTO getRequestForSingleState(String stateResourse) {

        Response response = restResponseConverter.getRequest(stateResourse);
        return restResponseConverter.objectRepresentationState(response);

    }

    public StateListResponseDTO getRequestForStatesList(String stateListResourse) {

        Response response = restResponseConverter.getRequest(stateListResourse);
        return restResponseConverter.objectRepresentationStateList(response);

    }

    protected void getRequestWithAnyFreeFormText() {
    }

}

