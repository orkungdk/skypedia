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
public class LocationRequest implements SkypediaRequest {

    private String country;

    private String city;

    private String latitude;

    private String longitude;

}
