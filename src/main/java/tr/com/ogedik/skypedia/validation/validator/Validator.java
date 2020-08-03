package tr.com.ogedik.skypedia.validation.validator;

import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.model.SkypediaModel;

import java.util.List;

/**
 * This interface represents a validator. All validator in this project needs to be implemented to the this class.
 * All validator should return a list of ErrorMessage unless termination of the process is really required.
 *
 * @author orkungedik
 */
public interface Validator<T extends SkypediaModel> {

    /**
     * @param validationBo to be validated business object
     * @param errorMessages error message list
     * @return List<{@link ErrorMessage}>
     */
    List<ErrorMessage> validate(T validationBo, List<ErrorMessage> errorMessages);

}
