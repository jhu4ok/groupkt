package scenarios;

import dto.countryservisedto.CountryResponseDTO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.StepsForCountryService;
import transfer.Context;


public class CountryObjectValidate {

    private final StepsForCountryService step = new StepsForCountryService();


    @Test
    public void successGetAllCountriesList() {

        Context<CountryResponseDTO> context = step.getAll();
        step.responseValidation(context, "src/test/java/expectedresults/country/resp_get_all.json");
    }

    @Test(dataProvider = "iso2Search")
    public void getCountryByIso2Code(String country, String expectedResult) {

        Context<CountryResponseDTO> context = step.getCountryByIso2Code(country);
        step.responseValidation(context, expectedResult);
    }

    @Test(dataProvider = "iso2SearchNothing")
    public void getNothingByIso2Code(String country, String expectedResult) {

        Context<CountryResponseDTO> context = step.getCountryByIso2Code(country);
        step.responseValidation(context, expectedResult);
    }

    @Test(dataProvider = "iso3Search")
    public void getCountryByIso3Code(String country, String expectedResult) {

        Context<CountryResponseDTO> context = step.getCountryByIso3Code(country);
        step.responseValidation(context, expectedResult);
    }

    @Test(dataProvider = "iso3SearchNothing")
    public void getNothingByIso3Code(String country, String expectedResult) {

        Context<CountryResponseDTO> context = step.getCountryByIso3Code(country);
        step.responseValidation(context, expectedResult);

    }

    @Test(dataProvider = "textSearch")
    public void getCountriesByAnyFreeFormText(String text, String expectedResult) {

        Context<CountryResponseDTO> context = step.getStateByText(text);
        step.responseValidation(context, expectedResult);
    }

    @Test(dataProvider = "textSearchNothing")
    public void getNothingMatchingFoundByAnyFreeFormText(String text, String expectedResult) {

        Context<CountryResponseDTO> context = step.getStateByText(text);
        step.responseValidation(context, expectedResult);
    }

    @DataProvider
    public static Object[][] iso2Search() {
        return new Object[][]{
                {"UA", "src/test/java/expectedresults/country/resp_iso2_ua.json"},
                {"RU", "src/test/java/expectedresults/country/resp_iso2_ru.json"},
                {"CZ", "src/test/java/expectedresults/country/resp_iso2_cz.json"}
        };
    }

    @DataProvider
    public static Object[][] iso2SearchNothing() {
        return new Object[][]{
                {"UJ", "src/test/java/expectedresults/country/resp_iso2_uj.json"},
                {"fg", "src/test/java/expectedresults/country/resp_iso2_fg.json"},
                {"USA", "src/test/java/expectedresults/country/resp_iso2_USA.json"}
        };
    }

    @DataProvider
    public static Object[][] iso3Search() {
        return new Object[][]{
                {"UKR", "src/test/java/expectedresults/country/resp_iso3_ua.json"},
                {"USA", "src/test/java/expectedresults/country/resp_iso3_usa.json"},
                {"ESP", "src/test/java/expectedresults/country/resp_iso3_esp.json"}
        };
    }

    @DataProvider
    public static Object[][] iso3SearchNothing() {
        return new Object[][]{
                {"UKJ", "src/test/java/expectedresults/country/resp_iso3_ukj.json"},
                {"ECP", "src/test/java/expectedresults/country/resp_iso3_ecp.json"},
                {"US", "src/test/java/expectedresults/country/resp_iso3_US.json"}
        };
    }

    @DataProvider
    public static Object[][] textSearch() {
        return new Object[][]{
                {"wa", "src/test/java/expectedresults/country/resp_text_wa.json"},
                {"all", "src/test/java/expectedresults/country/rest_text_all.json"},
                {"nor", "src/test/java/expectedresults/country/resp_text_nor.json"}
        };
    }
    @DataProvider
    public static Object[][] textSearchNothing() {
        return new Object[][]{
                {"wj", "src/test/java/expectedresults/country/resp_text_wj.json"},
                {"Epcx", "src/test/java/expectedresults/country/resp_text_epcx.json"},
                {"1", "src/test/java/expectedresults/country/resp_text_1.json"}
        };
    }

}
