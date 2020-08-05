package tr.com.ogedik.skypedia.validation.validator.booking;

import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.constant.TicketStatus;
import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.model.Booking;
import tr.com.ogedik.skypedia.validation.validator.Validator;

import java.util.List;

/**
 * @author orkungedik
 */
@Component
public class BookedTicketValidator implements Validator<Booking> {

    @Override
    public List<ErrorMessage> validate(Booking validationBo, List<ErrorMessage> errorMessages) {
        if (validationBo.getTicket().getTicketStatus().equals(TicketStatus.BOOKED)) {
            errorMessages.add(new ErrorMessage(ErrorType.TICKED_BOOKED, "Cannot book an already booked ticket", "ticket"));
        }

        return errorMessages;
    }
}
