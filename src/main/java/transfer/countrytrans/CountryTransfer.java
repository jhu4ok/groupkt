package transfer.countrytrans;

import io.restassured.response.Response;
import transfer.statetrans.StateTransfer;

import static io.restassured.RestAssured.given;

public class CountryTransfer extends StateTransfer {

    public Response getByCountryState(String path, String country, String state) {
        return given().pathParam("country", country).pathParam("state", state).spec(reqSpec.getBaseReqSpec()).when().get(path);
    }

    public Response getByText(String path, String text) {
        return given().pathParam("text", text).spec(reqSpec.getBaseReqSpec()).when().get(path);
    }

    public Response getAll(String path) {
        return given().spec(reqSpec.getBaseReqSpec()).when().get(path);
    }

    public Response getByIso2Code(String path, String alpha2Code) {
        return given().pathParam("alpha2Code", alpha2Code).spec(reqSpec.getBaseReqSpec()).when().get(path);
    }

    public Response getByIso3Code(String path, String alpha3Code) {
        return given().pathParam("alpha3Code", alpha3Code).spec(reqSpec.getBaseReqSpec()).when().get(path);
    }

}
