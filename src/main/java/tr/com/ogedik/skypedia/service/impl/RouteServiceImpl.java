package tr.com.ogedik.skypedia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.ogedik.skypedia.entity.RouteEntity;
import tr.com.ogedik.skypedia.mapper.entity.RouteEntityMapper;
import tr.com.ogedik.skypedia.model.Route;
import tr.com.ogedik.skypedia.repository.RouteRepository;
import tr.com.ogedik.skypedia.service.AuditLogService;
import tr.com.ogedik.skypedia.service.RouteService;
import tr.com.ogedik.skypedia.util.CommonServiceUtils;
import tr.com.ogedik.skypedia.util.MathUtils;
import tr.com.ogedik.skypedia.util.ObjectUtils;
import tr.com.ogedik.skypedia.validation.facade.RouteValidationFacade;

import java.util.List;

/**
 * @author orkungedik
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteEntityMapper mapper;
    @Autowired
    private RouteRepository repository;
    @Autowired
    private AuditLogService auditLogService;
    @Autowired
    private RouteValidationFacade validationFacade;

    @Override
    public Route create(Route route) {
        validationFacade.validateCreate(route);

        double lat1 = Double.valueOf(route.getDeparture().getLocation().getLatitude());
        double lon1 = Double.valueOf(route.getDeparture().getLocation().getLongitude());
        double lat2 = Double.valueOf(route.getDestination().getLocation().getLatitude());
        double lon2 = Double.valueOf(route.getDestination().getLocation().getLongitude());

        double distance = MathUtils.calculateDistance(lat1, lon1, lat2, lon2, "K");

        route.setDistance(Double.valueOf(distance).longValue());
        route.setEstimatedFlightTime(MathUtils.calculateTime(distance));

        RouteEntity entity = (RouteEntity) CommonServiceUtils.persistRecord(route, mapper, repository);
        auditLogService.logCreate(entity);

        return mapper.convert(entity);
    }

    @Override
    public Route retrieveById(Long id) {
        return (Route) CommonServiceUtils.retrieveById(id, mapper, repository);
    }

    @Override
    public List<Route> search(Route route) {
        List<RouteEntity> entities = repository.findAllByDepartureIdAndDestinationId(
                ObjectUtils.getNestedObjects(() -> route.getDeparture().getId()).orElse(null),
                ObjectUtils.getNestedObjects(() -> route.getDestination().getId()).orElse(null));

        return (List<Route>) mapper.convert(entities);
    }
}
