package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryResponseDTO {

    private CountryResponseDTO RestResponse;
    private List<String> messages;
    private CountryResponseDTO result;
    private String name;
    private String alpha2_code;
    private String alpha3_code;
}
