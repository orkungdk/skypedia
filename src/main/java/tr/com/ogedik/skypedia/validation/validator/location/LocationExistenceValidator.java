package tr.com.ogedik.skypedia.validation.validator.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.model.Location;
import tr.com.ogedik.skypedia.repository.LocationRepository;
import tr.com.ogedik.skypedia.validation.validator.Validator;

import java.util.List;

/**
 * @author orkungedik
 */
@Component
public class LocationExistenceValidator implements Validator<Location> {

    @Autowired
    private LocationRepository repository;

    @Override
    public List<ErrorMessage> validate(Location validationBo, List<ErrorMessage> errorMessages) {
        if (repository.findByCountryAndCity(validationBo.getCountry(), validationBo.getCity()).isPresent()) {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setStatus(ErrorType.ALREADY_EXISTED_DATA.getStatus());
            errorMessage.setTitle(ErrorType.ALREADY_EXISTED_DATA.getTitle());
            errorMessage.setDetail("There is already a location with same country and city");

            errorMessages.add(errorMessage);
        }

        return errorMessages;
    }
}
