package transfer.statetrans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import transfer.statetrans.routers.State;

@Getter
@EqualsAndHashCode
@ToString
public class StateApi {

    private State state = new State("");

}
