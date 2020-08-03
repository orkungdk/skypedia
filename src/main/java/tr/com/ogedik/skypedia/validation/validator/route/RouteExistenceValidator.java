package tr.com.ogedik.skypedia.validation.validator.route;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.ogedik.skypedia.entity.RouteEntity;
import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.model.Route;
import tr.com.ogedik.skypedia.repository.RouteRepository;
import tr.com.ogedik.skypedia.validation.validator.Validator;

import java.util.List;

/**
 * @author orkungedik
 */
@Component
public class RouteExistenceValidator implements Validator<Route> {

    @Autowired
    private RouteRepository repository;

    @Override
    public List<ErrorMessage> validate(Route route, List<ErrorMessage> errorMessages) {
        List<RouteEntity> entities = repository.findAllByDepartureIdAndDestinationId(route.getDeparture().getId(),
                                                                                     route.getDestination().getId());
        if (CollectionUtils.isNotEmpty(entities)) {
            errorMessages.add(new ErrorMessage(ErrorType.ALREADY_EXISTED_DATA, "Route is already exist", null));
        }

        return errorMessages;
    }
}
