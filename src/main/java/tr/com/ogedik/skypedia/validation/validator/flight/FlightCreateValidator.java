package tr.com.ogedik.skypedia.validation.validator.flight;

import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.model.Flight;
import tr.com.ogedik.skypedia.validation.validator.Validator;

import java.util.List;

/**
 * @author orkungedik
 */
@Component
public class FlightCreateValidator implements Validator<Flight> {

    @Override
    public List<ErrorMessage> validate(Flight validationBo, List<ErrorMessage> errorMessages) {
        if (validationBo.getInitialPrice() < 0) {
            errorMessages.add(new ErrorMessage(ErrorType.INVALID_INPUT, "Initial price cannot be less than zero.", "initialPrice"));
        }
        if (validationBo.getNumberOfSeats() < 0) {
            errorMessages.add(new ErrorMessage(ErrorType.INVALID_INPUT, "Number of the seats cannot be less than zero.", "numberOfSeats"));
        }

        return errorMessages;
    }
}
