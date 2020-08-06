package tr.com.ogedik.skypedia.model;

import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.skypedia.annotation.Required;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class Booking extends SkypediaModel {

    @Required
    private Ticket ticket;

    @Required
    private Long price;

    @Required
    private String cardNumber;

    @Required
    private String name;

    @Required
    private String surname;

    @Required
    private String email;

}
