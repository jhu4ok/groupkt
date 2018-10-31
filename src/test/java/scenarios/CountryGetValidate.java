package scenarios;

import dto.CountriesDTO;
import dto.CountryDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.JsonParserUtil;
import util.PropertiesUtil;

import java.io.IOException;
import java.util.List;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CountryGetValidate {


    @BeforeMethod
    public void setUp() throws IOException {
        RestAssured.baseURI = PropertiesUtil.getPropert("HOST_COUNTRY");
    }

    @Test

    public void getListOfAllCountriesTest() {

//        Response res =
//                given().
//                        when().get("/all").
//                        andReturn();
//        ResponseBody responseBody = res.getBody();
//       CountryDTO c =  responseBody.as(CountryDTO.class);
//        System.out.println(c);

//                        then().extract().response();


//        String resAsString = res.asString();
//        System.out.println(resAsString);
        Response res =
                given().
                        when().get("/all").
                        andReturn();
        ResponseBody responseBody = res.getBody();
        CountryDTO c =  responseBody.as(CountryDTO.class);
        System.out.println(c);
    }

//


    @Test
    public void getCountryByTwoCharacterAlphanumericISOCodeTest() {
    }

    @Test
    public void getCountryByThreeCharacterAlphanumericISOCodeTest() {
    }

    @Test
    public void getCountryByTwoOrThreeCharacterAlphanumericISOCodeTest() {
    }

}
