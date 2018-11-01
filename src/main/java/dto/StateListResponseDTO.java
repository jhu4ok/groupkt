package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;
@Getter
public class StateListResponseDTO {
    private StateListResponseDTO RestResponse;
    private List<String> messages;
    private List<StateListResponseDTO> result;
    private int id;
    private String country;
    private String name;
    private String abbr;
    private String area;
    private String largest_city;
    private String capital;
}
