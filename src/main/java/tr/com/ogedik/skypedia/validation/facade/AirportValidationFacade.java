package tr.com.ogedik.skypedia.validation.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.model.Airport;
import tr.com.ogedik.skypedia.validation.validator.AirportCapacityValidator;
import tr.com.ogedik.skypedia.validation.validator.AirportNameValidator;
import tr.com.ogedik.skypedia.validation.validator.MandatoryFieldValidator;

/**
 * @author orkungedik
 */
@Component
public class AirportValidationFacade implements ValidationFacade<Airport> {

    @Autowired
    private MandatoryFieldValidator mandatoryFieldValidator;
    @Autowired
    private AirportNameValidator airportNameValidator;
    @Autowired
    private AirportCapacityValidator airportCapacityValidator;

    public void validateCreate(Airport airport) {
        validate(airport, mandatoryFieldValidator, airportCapacityValidator, airportNameValidator);
    }
}
