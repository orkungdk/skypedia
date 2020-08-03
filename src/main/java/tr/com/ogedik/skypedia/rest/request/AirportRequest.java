package tr.com.ogedik.skypedia.rest.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class AirportRequest implements SkypediaRequest {

    private String name;

    private Long locationId;

    private Integer flightCapacity;

}
