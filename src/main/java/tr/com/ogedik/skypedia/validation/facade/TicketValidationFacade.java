package tr.com.ogedik.skypedia.validation.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.model.Ticket;
import tr.com.ogedik.skypedia.validation.validator.common.MandatoryFieldValidator;

/**
 * @author orkungedik
 */
@Component
public class TicketValidationFacade implements ValidationFacade<Ticket> {

    @Autowired
    private MandatoryFieldValidator mandatoryFieldValidator;

    @Override
    public void validateCreate(Ticket ticket) {
        validate(ticket, mandatoryFieldValidator);
    }
}
