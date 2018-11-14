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
    public void getCountryByIso2Code(String code,String country, String expectedResult) {

        Context<CountryResponseDTO> context = step.getCountryByIsoCode(code,country);
        step.responseValidation(context, expectedResult);
    }

    @Test(dataProvider = "iso2SearchNothing")
    public void getNothingByIso2Code(String code,String country, String expectedResult) {

        Context<CountryResponseDTO> context = step.getCountryByIsoCode(code, country);
        step.responseValidation(context, expectedResult);
    }

    @Test(dataProvider = "iso3Search")
    public void getCountryByIso3Code(String code,String country, String expectedResult) {

        Context<CountryResponseDTO> context = step.getCountryByIsoCode(code,country);
        step.responseValidation(context, expectedResult);
    }

    @Test(dataProvider = "iso3SearchNothing")
    public void getNothingByIso3Code(String code, String country, String expectedResult) {

        Context<CountryResponseDTO> context = step.getCountryByIsoCode(code, country);
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
                {"iso2code","UA", "src/test/java/expectedresults/country/resp_iso2_ua.json"},
                {"iso2code","RU", "src/test/java/expectedresults/country/resp_iso2_ru.json"},
                {"iso2code","CZ", "src/test/java/expectedresults/country/resp_iso2_cz.json"}
        };
    }

    @DataProvider
    public static Object[][] iso2SearchNothing() {
        return new Object[][]{
                {"iso2code", "UJ", "src/test/java/expectedresults/country/resp_iso2_uj.json"},
                {"iso2code", "fg", "src/test/java/expectedresults/country/resp_iso2_fg.json"},
                {"iso2code","USA", "src/test/java/expectedresults/country/resp_iso2_USA.json"}
        };
    }

    @DataProvider
    public static Object[][] iso3Search() {
        return new Object[][]{
                {"iso3code","UKR", "src/test/java/expectedresults/country/resp_iso3_ua.json"},
                {"iso3code","USA", "src/test/java/expectedresults/country/resp_iso3_usa.json"},
                {"iso3code","ESP", "src/test/java/expectedresults/country/resp_iso3_esp.json"}
        };
    }

    @DataProvider
    public static Object[][] iso3SearchNothing() {
        return new Object[][]{
                {"iso3code", "UKJ", "src/test/java/expectedresults/country/resp_iso3_ukj.json"},
                {"iso3code", "ECP", "src/test/java/expectedresults/country/resp_iso3_ecp.json"},
                {"iso3code","US", "src/test/java/expectedresults/country/resp_iso3_US.json"}
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
