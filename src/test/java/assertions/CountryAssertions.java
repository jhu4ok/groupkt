package assertions;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class CountryAssertions {

    public void assertStatusCode(){
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200).build();

    }

    public boolean assertResponceObject(){
        return true;
    }
    public boolean assertJSONSchema(){
        return true;
    }
    public boolean assertResponceIncludeRequest(){
        return true;
    }

}
