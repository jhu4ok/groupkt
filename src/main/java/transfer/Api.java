package transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Api {

    private State state = new State("");
    private Country country = new Country("");

}
