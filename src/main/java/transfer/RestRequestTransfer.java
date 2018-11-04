package transfer;

import dto.StateListResponseDTO;
import dto.StateResponseDTO;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import util.PropertiesUtil;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


public class RestRequestTransfer {

    public static String initialiseBaseURI() {
        RestAssured.baseURI = PropertiesUtil.getURL("HOST_STATE");
        return RestAssured.baseURI;
    }

    public StateListResponseDTO objectRepresentationStateList(Response response) {
        ResponseBody body = response.getBody();
        StateListResponseDTO stateListResponseDTO = body.as(StateListResponseDTO.class);
        return stateListResponseDTO;
    }

    public StateResponseDTO objectRepresentationState(Response response) {
        ResponseBody body = response.getBody();
        StateResponseDTO stateResponseDTO = body.as(StateResponseDTO.class);
        return stateResponseDTO;
    }

    public Response getRequest(String url) {
        Response response =
                get(url).
                        then().
//                        log().all().
                        extract().response();
        return response;
    }

    public Response getRequestUsingText(String key, String value, String url) {
        Response response =
                given().
                        param(key, value).
                        get(url).
                        then().
//                        log().all().
                        extract().response();
        return response;
    }



    @Test

    public static void getRequestForSingleState() {

//        Response response = RestRequestTransfer.getRequest("/USA/AK");
//        StateResponseDTO stateResponseDTO = RestRequestTransfer.objectRepresentationState(response);
//        System.out.println(stateResponseDTO.getRestResponse().getMessages());

    }


//    @Test
//    public void successGetResponse() {
////        Response response = RestRequestTransfer.getRequest("/USA/AK");
//
//
//        Response response =
//                given().
//                        get("/USA/AK");
//
//        ResponseBody body = response.getBody();
//
//        StateResponseDTO stateResponseDTO = body.as(StateResponseDTO.class);
//        System.out.println(stateResponseDTO.getRestResponse().getMessages());
//
//        Response response2 =
//                given().
//                        get("/USA/AK");
//
//        ResponseBody body2 = response.getBody();
//
//        StateResponseDTO stateResponseDTO2 = body2.as(StateResponseDTO.class);
//
//        System.out.println(stateResponseDTO.getRestResponse().getResult().getId());
//        System.out.println(stateResponseDTO.getRestResponse().getMessages());
////        System.out.println(responseBody.RestResponse.result.get(0).id);
////        Assert.assertEquals(responseBody.RestResponse.result.get(0).id, 82);
//    }
//
//    @Test
//    public void successGetAllResponse() {
//
//        Response response =
//                given().
//                        get("/IND/all");
//        ResponseBody body = response.getBody();
//        StateListResponseDTO responseBody = body.as(StateListResponseDTO.class);
//        System.out.println(responseBody.getRestResponse().getMessages());
//        System.out.println(response.getStatusCode());
////        Assert.assertEquals(responseBody.RestResponse.result.get(0).id, 65);
//        List<String> messageSuccess = new ArrayList<String>();
//        messageSuccess.add("Total [36] records found.");
//        Assert.assertEquals(responseBody.getRestResponse().getMessages(), messageSuccess);
//    }
//
//    @Test
//    public void failureResponse() {
//
//        Response response =
//                given().
//                        get("/IND/al");
//        ResponseBody body = response.getBody();
//        StateResponseDTO responseBody = body.as(StateResponseDTO.class);
//        System.out.println(responseBody.getRestResponse().getMessages());
////        List<String> messageFailure = new ArrayList<String>();
////
////       messageFailure.add("No matching state found for requested code [IND->al].");
//        String msg = "No matching state found for requested code [IND->al].";
//
//
////        Assert.assertEquals(responseBody.RestResponse.messages.get(0), msg);
//    }
//
//    @Test
//    public void successResponseList() {
//
//        Response response =
//                given().
//                        get("/IND/all");
//        ResponseBody body = response.getBody();
//        StateListResponseDTO responseBody = body.as(StateListResponseDTO.class);
//        System.out.println(responseBody.getRestResponse().getMessages());
//
//        List<String> messageSuccess = new ArrayList<String>();
//        messageSuccess.add("Total [36] records found.");
//        Assert.assertEquals(responseBody.getRestResponse().getMessages(), messageSuccess);
//
//
//    }


}
