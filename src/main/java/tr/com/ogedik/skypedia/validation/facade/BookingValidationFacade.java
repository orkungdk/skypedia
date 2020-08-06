package tr.com.ogedik.skypedia.validation.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.model.Booking;
import tr.com.ogedik.skypedia.validation.validator.booking.BookedTicketValidator;
import tr.com.ogedik.skypedia.validation.validator.booking.BookingPriceValidator;
import tr.com.ogedik.skypedia.validation.validator.booking.CreditCardValidator;
import tr.com.ogedik.skypedia.validation.validator.common.MandatoryFieldValidator;

/**
 * @author orkungedik
 */
@Component
public class BookingValidationFacade implements ValidationFacade<Booking> {

    @Autowired
    private MandatoryFieldValidator mandatoryFieldValidator;
    @Autowired
    private BookedTicketValidator bookedTicketValidator;
    @Autowired
    private BookingPriceValidator bookingPriceValidator;
    @Autowired
    private CreditCardValidator creditCardValidator;

    @Override
    public void validateCreate(Booking booking) {
        validate(booking, mandatoryFieldValidator, bookedTicketValidator, bookingPriceValidator, creditCardValidator);
    }
}
