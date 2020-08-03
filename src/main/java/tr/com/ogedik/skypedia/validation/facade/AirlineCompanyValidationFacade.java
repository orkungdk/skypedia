package tr.com.ogedik.skypedia.validation.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.model.AirlineCompany;
import tr.com.ogedik.skypedia.validation.validator.airlines.AirlineCompanyCreateValidator;
import tr.com.ogedik.skypedia.validation.validator.airlines.AirlineCompanyNameValidator;
import tr.com.ogedik.skypedia.validation.validator.common.MandatoryFieldValidator;

/**
 * @author orkungedik
 */
@Component
public class AirlineCompanyValidationFacade implements ValidationFacade<AirlineCompany> {

    @Autowired
    private MandatoryFieldValidator mandatoryFieldValidator;
    @Autowired
    private AirlineCompanyNameValidator airlineCompanyNameValidator;
    @Autowired
    private AirlineCompanyCreateValidator airlineCompanyCreateValidator;

    public void validateCreate(AirlineCompany airlineCompany) {
        validate(airlineCompany, mandatoryFieldValidator, airlineCompanyNameValidator, airlineCompanyCreateValidator);
    }
}
