package transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import transfer.routers.State;

@Getter
@EqualsAndHashCode
@ToString
public class Api {

    private State state = new State("");

}
