//package transfer;
//
//import dto.countryservisedto.CountryResponseDTO;
//import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
//
//public class CountryResponseTransfer extends MainResponseTransfer {
//
//    public CountryResponseDTO objectRepresentationCountriesList(Response response) {
//        ResponseBody body = response.getBody();
//        CountryResponseDTO resp = body.as(CountryResponseDTO.class);
//        return resp;
//    }
//
//}
