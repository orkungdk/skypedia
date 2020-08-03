package tr.com.ogedik.skypedia.validation.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.model.Route;
import tr.com.ogedik.skypedia.validation.validator.common.MandatoryFieldValidator;
import tr.com.ogedik.skypedia.validation.validator.route.RouteExistenceValidator;

/**
 * @author orkungedik
 */
@Component
public class RouteValidationFacade implements ValidationFacade<Route> {

    @Autowired
    private MandatoryFieldValidator mandatoryFieldValidator;
    @Autowired
    private RouteExistenceValidator routeExistenceValidator;

    @Override
    public void validateCreate(Route route) {
        validate(route, mandatoryFieldValidator, routeExistenceValidator);
    }

}
