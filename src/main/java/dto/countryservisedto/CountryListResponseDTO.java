package dto.countryservisedto;

import lombok.Getter;

import java.util.List;

@Getter
public class CountryListResponseDTO {

    private List<String> messages;
    private List<CountryDTO> result;
}
