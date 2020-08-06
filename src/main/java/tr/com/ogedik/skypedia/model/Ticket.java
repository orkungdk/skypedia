package tr.com.ogedik.skypedia.model;

import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.skypedia.annotation.Required;
import tr.com.ogedik.skypedia.constant.TicketStatus;

import java.time.LocalDateTime;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class Ticket extends SkypediaModel {

	@Required
	private Flight flight;

	private Long price;

	private TicketStatus ticketStatus;

}
