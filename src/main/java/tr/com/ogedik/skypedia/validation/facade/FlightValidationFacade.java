package tr.com.ogedik.skypedia.validation.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.model.Flight;
import tr.com.ogedik.skypedia.validation.validator.common.MandatoryFieldValidator;
import tr.com.ogedik.skypedia.validation.validator.flight.FlightCreateValidator;

/**
 * @author orkungedik
 */
@Component
public class FlightValidationFacade implements ValidationFacade<Flight> {
    @Autowired
    private MandatoryFieldValidator mandatoryFieldValidator;
    @Autowired
    private FlightCreateValidator flightCreateValidator;

    @Override
    public void validateCreate(Flight flight) {
        validate(flight, mandatoryFieldValidator, flightCreateValidator);

    }
}
