package tr.com.ogedik.skypedia.rest.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class FlightRequest implements SkypediaRequest {

    private Long airlineCompanyId;

    private Integer numberOfSeats;

    private Long initialPrice;

    private Long routeId;

    private LocalDateTime departureAt;
}
