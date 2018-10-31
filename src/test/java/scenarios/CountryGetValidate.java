package scenarios;

import dto.CountriesDTO;
import dto.CountryDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.JsonParserUtil;
import util.PropertiesUtil;

import java.io.IOException;
import java.util.List;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;


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
        CountryDTO c = responseBody.as(CountryDTO.class);
        System.out.println(c);

        CountriesDTO countriesDTO = given().when().get("/all").then().statusCode(200).extract().as(CountriesDTO.class);
        Assert.assertNotNull(countriesDTO.countries);
//                assertThat(countriesDTO.countries).isNotEmpty();


//        @Test
//        public void getAllBlogsWithMapping(){
//            BlogListDTO retrievedBlogs = given()
//                    .spec(spec)
//                    .when()
//                    .get("blogs")
//                    .then()
//                    .statusCode(200)
//                    .extract().as(BlogListDTO.class);
//            assertThat(retrievedBlogs.count).isGreaterThan(7);
//
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
