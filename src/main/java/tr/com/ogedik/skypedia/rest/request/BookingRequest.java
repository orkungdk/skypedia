package tr.com.ogedik.skypedia.rest.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class BookingRequest implements SkypediaRequest {

    private Long ticketId;

    private Long price;

    private String cardNumber;

    private String name;

    private String surname;

    private String email;

}
