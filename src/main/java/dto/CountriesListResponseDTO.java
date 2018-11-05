package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountriesListResponseDTO {

    private CountriesListResponseDTO RestResponse;
    private List<String> messages;
    private List<CountriesListResponseDTO> result;
    private String name;
    private String alpha2_code;
    private String alpha3_code;

}
