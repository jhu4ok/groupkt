package dto;


import lombok.*;

@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)  @AllArgsConstructor
public class StateDTO {
    int id;
    private String country;
    private String name;
    private String abbr;
    private String area;
    private String largest_city;
    private String capital;
}
