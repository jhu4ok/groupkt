package dto.countryservisedto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class CountryListResponseDTO {

    private List<String> messages;
    private List<CountryDTO> result;
}
