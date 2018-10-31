package dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)  @AllArgsConstructor
public class CountryDTO {
    String name;
    String alpha2_code;
    String alpha3_code;
}
