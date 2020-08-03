package tr.com.ogedik.skypedia.rest.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author orkungedik
 */
@Getter
@Setter
@ToString
public class AirlineCompanyRequest implements SkypediaRequest {

    private String name;

    private String shortName;

}
