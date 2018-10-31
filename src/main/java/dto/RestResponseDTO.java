package dto;

public class RestResponseDTO {

    private RestResponse restResponse;

    public RestResponseDTO() {
        super();
    }

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }

    @Override
    public String toString() {
        return "RestResponseDTO [RestResponse=" + restResponse + "]";
    }

}
