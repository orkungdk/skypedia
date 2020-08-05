package tr.com.ogedik.skypedia.validation.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.model.Booking;
import tr.com.ogedik.skypedia.validation.validator.common.MandatoryFieldValidator;

/**
 * @author orkungedik
 */
@Component
public class BookingValidationFacade implements ValidationFacade<Booking> {

    @Autowired
    private MandatoryFieldValidator mandatoryFieldValidator;

    @Override
    public void validateCreate(Booking model) {

    }
}
