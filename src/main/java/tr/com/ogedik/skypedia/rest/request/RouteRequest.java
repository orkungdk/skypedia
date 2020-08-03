package tr.com.ogedik.skypedia.rest.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class RouteRequest implements SkypediaRequest {

    private Long destinationId;

    private Long departureId;

}
