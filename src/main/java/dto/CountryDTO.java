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
    @Override
    public String toString() {
        return "CountryDTO [name=" + name + ", alpha2_code=" + alpha2_code + ", alpha3_code=" + alpha3_code + "]";
    }
}
