package assertions;

import io.restassured.response.Response;
import org.testng.Assert;


public class MainAssertions {

    public void assertStatusCode(Response response, int expectedStatusCode) {

        int actualStatusCode = response.statusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Incorrect Status Code");

    }


}
