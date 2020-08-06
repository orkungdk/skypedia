package tr.com.ogedik.skypedia.validation.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.model.Airport;
import tr.com.ogedik.skypedia.validation.validator.airport.AirportNameValidator;
import tr.com.ogedik.skypedia.validation.validator.common.MandatoryFieldValidator;

/**
 * @author orkungedik
 */
@Component
public class AirportValidationFacade implements ValidationFacade<Airport> {

    @Autowired
    private MandatoryFieldValidator mandatoryFieldValidator;
    @Autowired
    private AirportNameValidator airportNameValidator;

    public void validateCreate(Airport airport) {
        validate(airport, mandatoryFieldValidator, airportNameValidator);
    }
}
