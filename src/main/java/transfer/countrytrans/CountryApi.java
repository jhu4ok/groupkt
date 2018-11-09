package transfer.countrytrans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import transfer.countrytrans.routers.Country;

@Getter
@EqualsAndHashCode
@ToString
public class CountryApi {
    private Country country = new Country("");
}
