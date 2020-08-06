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

        String cardNumber = validationBo.getCardNumber().replaceAll(" ", "")
                .replaceAll("-", "")
                .replaceAll(",", "");

        if (cardNumber.matches("^[0-9]{16}$")) {
            validationBo.setCardNumber(cardNumber.substring(0, 6) + "******" + cardNumber.substring(cardNumber.length() - 4));
        } else {
            errorMessages.add(new ErrorMessage(ErrorType.INVALID_INPUT, "Card number length must be 16.", "cardNumber"));
        }

        return errorMessages;
    }
}