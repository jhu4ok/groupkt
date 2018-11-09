package assertions;

import dto.countryservisedto.CountryResponseDTO;
import org.testng.Assert;


public class CountryServiceAssertions extends MainAssertions {

    public static void assertObjectMessage(CountryResponseDTO country, CountryResponseDTO expCountry) {
        Assert.assertEquals(country.getRestResponse().getMessages(), expCountry.getRestResponse().getMessages());
    }

    public void assertObjectResult(CountryResponseDTO country, CountryResponseDTO expCountry) {
        Assert.assertEquals(country.getRestResponse().getResult(), expCountry.getRestResponse().getResult());
    }
}
