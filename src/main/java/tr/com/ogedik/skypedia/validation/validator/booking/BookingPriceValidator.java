package tr.com.ogedik.skypedia.validation.validator.booking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.model.Booking;
import tr.com.ogedik.skypedia.validation.validator.Validator;

import java.util.List;

/**
 * @author orkungedik
 */
@Component
public class BookingPriceValidator implements Validator<Booking> {

    private static final Logger LOGGER = LogManager.getLogger(BookingPriceValidator.class);

    @Override
    public List<ErrorMessage> validate(Booking validationBo, List<ErrorMessage> errorMessages) {
        if (validationBo.getPrice() != validationBo.getTicket().getPrice()) {
            LOGGER.error("Actual price: {}. Expected price: {}", validationBo.getPrice(), validationBo.getTicket().getPrice());
            errorMessages.add(new ErrorMessage(ErrorType.INSUFFICIENT_AMOUNT, "Payment amount is not correct", "price"));
        }
        return errorMessages;
    }
}
