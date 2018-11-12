package assertions;

import org.testng.Assert;


public class MainAssertions {

    public static void assertStatusCode(int actualStatCode, int expectedStatCode) {
        Assert.assertEquals(actualStatCode, expectedStatCode, "Incorrect Status Code");
    }

}
