package tr.com.ogedik.skypedia.validation.facade;

import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.SkypediaException;
import tr.com.ogedik.skypedia.model.SkypediaModel;
import tr.com.ogedik.skypedia.validation.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This interface represents a validation facade. All validation facades needs to be implemented to this class.
 * At the end of the validate method, check the {@link tr.com.ogedik.skypedia.exception.ErrorMessage} list
 * and throws an exception in case of the list is not empty.
 *
 * @author orkungedik
 */
public interface ValidationFacade<T extends SkypediaModel> {

    void validateCreate(T model);

    default void validate(T validationBo, Validator... validators) {
        if (validators == null) {
            return;
        }
        List<ErrorMessage> errorMessages = new ArrayList<>();
        Arrays.asList(validators).forEach(validator -> validator.validate(validationBo, errorMessages));

        if (!errorMessages.isEmpty()) {
            throw new SkypediaException(errorMessages);
        }
    }
}
