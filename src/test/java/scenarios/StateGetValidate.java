package scenarios;

import com.google.gson.Gson;
import dto.CountriesDTO;
import dto.CountryDTO;
import dto.State;
import dto.StateDTO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import transfer.StateDTOConverter;
import util.PropertiesUtil;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class StateGetValidate {
    @BeforeMethod
    public void setUp() throws IOException {
        RestAssured.baseURI = PropertiesUtil.getPropert("HOST_STATE");
    }

    @Test
    public void getListOfAllStatesOfACountryTest() {
    }

    @Test

    public void getStateOfACountryByStateCodeTest() {
//        StateDTO stateDTO =
//                given().
//                        when().get("/IND/UP").
//                       then().
//                        statusCode(200).extract().as(StateDTO.class);
//
//
//
//        Gson gson = new Gson();
//        String json = gson.toJson(stateDTO);
//        System.out.println( json);

//        Response response = get(ROOT_URI + "/list");
//        System.out.println(response.asString());
//
//        response.then().body("id", hasItems(1, 2));
//        response.then().body("name", hasItems("Pankaj"));


//        State res =
//                given().
//                when().get("/IND/UP").then().extract().as(State.class);
//        StateDTO stateDTO= StateDTOConverter.toDTO(res);
//
//        System.out.println(stateDTO.id);

//        res.then().body("id", hasItems(82));


//        Assert.assertNotNull(stateDTO.getId());
//        System.out.println(stateDTO.getName());

        String  js =
                given().
                        when().
                        get("/IND/UP").
                        then().extract().body().asString();
        Gson gson = new Gson();
        StateDTO stateDTO = gson.fromJson(js, StateDTO.class);
//        json = gson.toJson(obj);
//        StateDTO stateDTO = jsonPath.

//        List<StateDTO> stateDTOS = jsonPath.getList(StateDTO.class);
        System.out.println(js);
        System.out.println(stateDTO);
    }

    @Test
    public void getStateByAnyTextTest() {
    }
}
