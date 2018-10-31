package scenarios;

import com.google.gson.Gson;
import dto.CountriesDTO;
import dto.CountryDTO;
import dto.StateDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.PropertiesUtil;
import org.hamcrest.Matchers;

import java.io.IOException;

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

        StateDTO res = given().
                when().get("/IND/UP").then().extract().as(StateDTO.class);

        System.out.println(res.toString());

//        res.then().body("id", hasItems(82));






//        Assert.assertNotNull(stateDTO.getId());
//        System.out.println(stateDTO.getName());
    }

    @Test
    public void getStateByAnyTextTest() {
    }
}
