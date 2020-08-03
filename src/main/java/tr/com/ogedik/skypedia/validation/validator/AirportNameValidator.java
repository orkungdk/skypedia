package tr.com.ogedik.skypedia.validation.validator;

import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.model.Airport;
import tr.com.ogedik.skypedia.util.CommonValidatorUtils;

import java.util.List;

/**
 * @author orkungedik
 */
@Component
public class AirportNameValidator implements Validator<Airport> {

    /**
     * Validates airport name
     *
     * @param validationBo to be validated business object
     * @param errorMessages error message list
     * @return error message list
     */
    @Override
    public List<ErrorMessage> validate(Airport validationBo, List<ErrorMessage> errorMessages) {
        String name = validationBo.getName();
        if (name.isEmpty()) {
            errorMessages.add(new ErrorMessage(ErrorType.INVALID_INPUT, "Airport name cannot be empty", "name"));
        } else {
            CommonValidatorUtils.validateRomanized(errorMessages, name);
        }

        return errorMessages;
    }
}
