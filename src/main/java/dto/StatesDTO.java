package dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)  @AllArgsConstructor
public class StatesDTO {
    List<StatesDTO> states;
}
