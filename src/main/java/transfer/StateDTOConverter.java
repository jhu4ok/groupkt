package transfer;

import dto.State;
import dto.StateDTO;

public class StateDTOConverter {
    public static StateDTO toDTO(State state) {

        StateDTO stateDTO = new StateDTO();

        stateDTO.id = state.getId();
        stateDTO.country = state.getCountry();
        stateDTO.name = state.getName();
        stateDTO.abbr = state.getAbbr();
        stateDTO.area = state.getArea();
        stateDTO.largest_city = state.getLargest_city();
        stateDTO.capital = state.getCapital();

        return stateDTO;
    }
}
