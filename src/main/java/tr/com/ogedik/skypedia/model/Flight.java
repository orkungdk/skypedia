package tr.com.ogedik.skypedia.model;

import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.skypedia.annotation.Required;

import java.time.LocalDateTime;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class Flight extends SkypediaModel {

    @Required
    private AirlineCompany airlineCompany;

    @Required
    private Integer numberOfSeats;

    @Required
    private Long initialPrice;

    @Required
    private Route route;

    @Required
    private LocalDateTime departureAt;

}
