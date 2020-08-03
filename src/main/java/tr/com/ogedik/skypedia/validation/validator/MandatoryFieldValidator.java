package tr.com.ogedik.skypedia.validation.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import tr.com.ogedik.skypedia.annotation.Required;
import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.exception.SkypediaException;
import tr.com.ogedik.skypedia.model.SkypediaModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author orkungedik
 */
@Component
public class MandatoryFieldValidator implements Validator<SkypediaModel> {

    /**
     * Validates that the required fields are not empty.
     *
     * @param object {@link SkypediaModel}
     */
    @Override
    public List<ErrorMessage> validate(SkypediaModel object, List<ErrorMessage> errorMessages) {
        if (object == null) {
            throw new SkypediaException(ErrorType.INVALID_INPUT, "Input value cannot be null.");
        }
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            Optional<Annotation> requiredAnnotation = Arrays.stream(field.getDeclaredAnnotations())
                    .filter(annotation -> annotation instanceof Required)
                    .findFirst();

            if (requiredAnnotation.isPresent() && ObjectUtils.isEmpty(getObject(field, object))) {
                ErrorMessage errorMessage = new ErrorMessage();
                errorMessage.setTitle(ErrorType.MISSING_FIELD_VALUE.getTitle());
                errorMessage.setStatus(ErrorType.MISSING_FIELD_VALUE.getStatus());
                errorMessage.setDetail(((Required) requiredAnnotation.get()).message());
                errorMessage.setPointer(field.getName());

                errorMessages.add(errorMessage);
            }
        }
        /*
         * In case of a mandatory field is missing, process needs to be terminated.
         * Otherwise, NullPointerException may be thrown in the other validators.
         */
        if (!errorMessages.isEmpty()) {
            throw new SkypediaException(errorMessages);
        }

        return errorMessages;
    }

    /**
     * Returns object value from field
     *
     * @param field  mandatory field to validate
     * @param object instance of an object to validate
     * @return value of the {@code field} in the given {@code object}
     * @throws SkypediaException if IllegalAccessException is thrown
     */
    private Object getObject(Field field, Object object) {
        try {
            return field.get(object);
        } catch (IllegalAccessException e) {
            throw new SkypediaException(e);
        }
    }
}
