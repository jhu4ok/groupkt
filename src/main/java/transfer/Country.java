package transfer;

import lombok.Getter;
import transfer.routers.country.ByIsoCode;
import transfer.routers.country.GetAll;
import transfer.routers.country.ByText;

public class Country {
    private static final String ROUT = "/country";
    private final BaseTransfer baseTransfer = new BaseTransfer();
    private final String path;

    @Getter
    private final GetAll getAll;
    @Getter
    private final ByIsoCode byIso3Code;
    @Getter
    private final ByText byText;


    public Country(String parentRout) {
        path = parentRout + ROUT;
        getAll = new GetAll(path);
        byIso3Code = new ByIsoCode(path);
        byText = new ByText(path);
    }
}
