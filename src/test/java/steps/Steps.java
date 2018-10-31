package steps;

import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.from;

public class Steps {


    public String getCountry() {
        String response = when().get("/all").
                then().extract().response().asString();
        return response;

    }
    public void compareResultWithSentData(String response){
        List<String> profilesResponse = from(response).getList("/all");

        boolean profileFlag = true;
        for ( String s:profilesResponse ){

        }
    }
}
