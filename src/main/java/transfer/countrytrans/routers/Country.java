package transfer.countrytrans.routers;

import lombok.Getter;
import transfer.statetrans.StateTransfer;
import transfer.countrytrans.routers.country.ByIso2Code;
import transfer.countrytrans.routers.country.ByIso3Code;
import transfer.countrytrans.routers.country.GetAll;
import transfer.countrytrans.routers.country.ByText;

public class Country {
    private static final String ROUT = "/country";
    private final StateTransfer baseTransfer = new StateTransfer();
    private final String path;

    @Getter
    private final GetAll getAll;
    @Getter
    private final ByIso2Code byIso2Code;
    @Getter
    private final ByIso3Code byIso3Code;
    @Getter
    private final ByText byText;


    public Country(String parentRout) {
        path = parentRout + ROUT;
        getAll = new GetAll(path);
        byIso2Code = new ByIso2Code(path);
        byIso3Code = new ByIso3Code(path);
        byText = new ByText(path);
    }
}
