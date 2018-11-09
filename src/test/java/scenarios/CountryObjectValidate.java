package scenarios;


import dto.countryservisedto.CountryResponseDTO;
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

    @Test
    public void getCountryByIso2Code() {

        Context<CountryResponseDTO> context = step.getCountryByIso2Code("UA");
        step.responseValidation(context, "src/test/java/expectedresults/country/resp_iso2_ua.json");
    }

    @Test
    public void getNothingByIso2Code() {

        Context<CountryResponseDTO> context = step.getCountryByIso2Code("UJ");
        step.responseValidation(context, "src/test/java/expectedresults/country/resp_iso2_uj.json");
    }

    @Test
    public void getCountryByIso3Code() {

        Context<CountryResponseDTO> context = step.getCountryByIso3Code("UKR");
        step.responseValidation(context, "src/test/java/expectedresults/country/resp_iso3_ua.json");
    }

    @Test
    public void getNothingByIso3Code() {

        Context<CountryResponseDTO> context = step.getCountryByIso3Code("UKJ");
        step.responseValidation(context, "src/test/java/expectedresults/country/resp_iso3_ukj.json");

    }

    @Test
    public void getCountriesByAnyFreeFormText() {

        Context<CountryResponseDTO> context = step.getStateByText("wa");
        step.responseValidation(context, "src/test/java/expectedresults/country/resp_text_wa.json");
    }

    @Test
    public void getNothingMatchingFoundByAnyFreeFormText() {

        Context<CountryResponseDTO> context = step.getStateByText("wj");
        step.responseValidation(context, "src/test/java/expectedresults/country/resp_text_wj.json");
    }

}
