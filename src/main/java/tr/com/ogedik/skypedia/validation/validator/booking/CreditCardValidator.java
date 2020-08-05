package tr.com.ogedik.skypedia.validation.validator.booking;

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
public class CreditCardValidator implements Validator<Booking> {

    @Override
    public List<ErrorMessage> validate(Booking validationBo, List<ErrorMessage> errorMessages) {
        if (!validationBo.getCardNumber().matches("^[0-9]{2}$")) {
            errorMessages.add(new ErrorMessage(ErrorType.INVALID_INPUT, "Card number is not valid.", "cardNumber"));
        }

        return errorMessages;
    }
}
