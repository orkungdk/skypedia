package tr.com.ogedik.skypedia.validation.validator;

import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.model.AirlineCompany;
import tr.com.ogedik.skypedia.util.CommonValidatorUtils;

import java.util.List;

/**
 * @author orkungedik
 */
@Component
public class AirlineCompanyNameValidator implements Validator<AirlineCompany> {

    private static final String SHORT_NAME = "shortName";
    private static final String NAME = "name";

    @Override
    public List<ErrorMessage> validate(AirlineCompany validationBo, List<ErrorMessage> errorMessages) {
        String companyName = validationBo.getName();
        String shortName = validationBo.getShortName();

        validateName(errorMessages, companyName);
        validateShortName(errorMessages, shortName);

        return errorMessages;
    }

    /**
     * Validates {@link AirlineCompany#getName()}
     * 1- Checks if the name is empty
     * 2- Checks if the name starts with white space
     * 3- Checks if the name ends with white space
     * 4- Checks if the name contains non-romanized characters
     *
     * @param errorMessages error message list
     * @param companyName   to be validated company name
     */
    private void validateName(List<ErrorMessage> errorMessages, String companyName) {
        if (companyName.isEmpty()) {
            errorMessages.add(createErrorMessage("Company name cannot be empty.", NAME));
        } else {
            CommonValidatorUtils.validateRomanized(errorMessages, companyName);
        }
    }

    /**
     * Validates {@link AirlineCompany#getShortName()}
     * 1- Checks if the name is empty
     * 2- Checks if the name starts with white space
     * 3- Checks if the name ends with white space
     * 4- Checks if the name contains non-romanized characters
     * 5- Checks if the name contains white space
     * 6- Checks if the name length more than 3 and less then 2
     *
     * @param errorMessages    error message list
     * @param companyShortName to be validated company short name
     */
    private void validateShortName(List<ErrorMessage> errorMessages, String companyShortName) {
        if (companyShortName.isEmpty()) {
            errorMessages.add(createErrorMessage("Company short name cannot be empty.", NAME));
        } else {
            CommonValidatorUtils.validateRomanized(errorMessages, companyShortName);

            if (companyShortName.contains(" ")) {
                errorMessages.add(createErrorMessage("Company short name cannot contain white space.", SHORT_NAME));
            }
            if (companyShortName.length() > 3 || companyShortName.length() < 2) {
                errorMessages.add(createErrorMessage("Company short name must be 2 or 3 letters.", SHORT_NAME));
            }
        }

    }

    /**
     * Creates an instance of {@link ErrorMessage} with the given error details.
     *
     * @param detail error detail
     * @return {@link ErrorMessage}
     */
    private ErrorMessage createErrorMessage(String detail, String pointer) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setTitle(ErrorType.INVALID_INPUT.getTitle());
        errorMessage.setStatus(ErrorType.INVALID_INPUT.getStatus());
        errorMessage.setPointer(pointer);
        errorMessage.setDetail(detail);

        return errorMessage;
    }
}
