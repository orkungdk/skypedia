package tr.com.ogedik.skypedia.util;

import lombok.experimental.UtilityClass;
import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.ErrorType;

import java.util.List;

/**
 * @author orkungedik
 */
@UtilityClass
public class CommonValidatorUtils {

    /**
     * Executes the common name validations
     *
     * @param errorMessages error message list
     * @param name to be validated name
     */
    public static void validateRomanized(List<ErrorMessage> errorMessages, String name) {
        validateStartCharacter(errorMessages, name);
        validateEndCharacter(errorMessages, name);
        validateRomanizedCharacters(errorMessages, name);
    }

    /**
     * Validates that each character in the given string is a romanized character
     *
     * @param errorMessages error message list
     * @param name to be validated name
     */
    public static void validateRomanizedCharacters(List<ErrorMessage> errorMessages, String name) {
        // ignore white spaces for the given name to be able to match with regex
        String tempName = name.replaceAll(" ", "");

        if (!tempName.matches("^[a-zA-Z]*$")) {
            errorMessages.add(createErrorMessage("Company name can contains only romanized characters."));
        }
    }

    /**
     * Validates that given string does not end with white space
     *
     * @param errorMessages error message list
     * @param name to be validated name
     */
    public static void validateEndCharacter(List<ErrorMessage> errorMessages, String name) {
        if (name.endsWith(" ")) {
            errorMessages.add(createErrorMessage("Name cannot end with a white space"));
        }
    }

    /**
     * Validates that given string does not start with white space
     *
     * @param errorMessages error message list
     * @param name to be validated name
     */
    public static void validateStartCharacter(List<ErrorMessage> errorMessages, String name) {
        if (name.startsWith(" ")) {
            errorMessages.add(createErrorMessage("Name cannot start with a white space"));
        }
    }

    /**
     * Creates an instance of {@link ErrorMessage} with the given error details.
     *
     * @param detail error detail
     * @return {@link ErrorMessage}
     */
    private ErrorMessage createErrorMessage(String detail) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setTitle(ErrorType.INVALID_INPUT.getTitle());
        errorMessage.setStatus(ErrorType.INVALID_INPUT.getStatus());
        errorMessage.setDetail(detail);

        return errorMessage;
    }

}
