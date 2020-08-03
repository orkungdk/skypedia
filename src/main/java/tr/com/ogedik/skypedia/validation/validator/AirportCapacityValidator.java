package tr.com.ogedik.skypedia.validation.validator;

import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.model.Airport;

import java.util.List;

/**
 * @author orkungedik
 */
@Component
public class AirportCapacityValidator implements Validator<Airport> {

    /**
     * Validates airport capacity number
     *
     * @param validationBo  to be validated business object
     * @param errorMessages error message list
     * @return error message list
     */
    @Override
    public List<ErrorMessage> validate(Airport validationBo, List<ErrorMessage> errorMessages) {
        if (validationBo.getFlightCapacity() != null) {
            if (validationBo.getFlightCapacity() < 1) {
                errorMessages.add(new ErrorMessage(ErrorType.INVALID_INPUT, "Flight capacity cannot be smaller than 1", "flightCapacity"));
            }
        }

        return errorMessages;
    }
}
