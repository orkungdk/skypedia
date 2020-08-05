package tr.com.ogedik.skypedia.rest.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class TicketRequest implements SkypediaRequest {

    private Long flightId;

}
