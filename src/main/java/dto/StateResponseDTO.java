package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class StateResponseDTO {

    private StateResponseDTO RestResponse;
    private List<String> messages;
    private StateResponseDTO result;
    private int id;
    private String country;
    private String name;
    private String abbr;
    private String area;
    private String largest_city;
    private String capital;
}
