package tr.com.ogedik.skypedia.validation.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.model.Location;
import tr.com.ogedik.skypedia.validation.validator.location.LocationExistenceValidator;
import tr.com.ogedik.skypedia.validation.validator.common.MandatoryFieldValidator;

/**
 * @author orkungedik
 */
@Component
public class LocationValidationFacade implements ValidationFacade<Location> {

    @Autowired
    private MandatoryFieldValidator mandatoryFieldValidator;
    @Autowired
    private LocationExistenceValidator locationExistenceValidator;

    public void validateCreate(Location location) {
        validate(location, mandatoryFieldValidator, locationExistenceValidator);
    }
}
