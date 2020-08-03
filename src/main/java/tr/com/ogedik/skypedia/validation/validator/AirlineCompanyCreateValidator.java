package tr.com.ogedik.skypedia.validation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.entity.AirlineCompanyEntity;
import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.model.AirlineCompany;
import tr.com.ogedik.skypedia.repository.AirlineCompanyRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author orkungedik
 */
@Component
public class AirlineCompanyCreateValidator implements Validator<AirlineCompany> {

    @Autowired
    private AirlineCompanyRepository repository;

    /**
     * Adds an error exception if there is a record with the same name or shortName
     *
     * @param validationBo to be validated business object
     * @param errorMessages error message list
     * @return List<{@link ErrorMessage}>
     */
    @Override
    public List<ErrorMessage> validate(AirlineCompany validationBo, List<ErrorMessage> errorMessages) {
        Optional<AirlineCompanyEntity> optional = repository.findAirlineCompany(validationBo.getName(),
                validationBo.getShortName());

        if (optional.isPresent()) {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setTitle(ErrorType.INVALID_INPUT.getTitle());
            errorMessage.setDetail("Company is already exist for values : " + validationBo.toString());
            errorMessage.setStatus(400);

            errorMessages.add(errorMessage);
        }

        return errorMessages;
    }
}
