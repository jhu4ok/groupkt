package dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @AllArgsConstructor
public class CountriesDTO {

    public List <CountryDTO> countries;
    public int count = countries.size();
}
