package tr.com.ogedik.skypedia.mapper.request;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import tr.com.ogedik.skypedia.model.Route;
import tr.com.ogedik.skypedia.rest.request.RouteRequest;
import tr.com.ogedik.skypedia.service.AirportService;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring")
public abstract class RouteMapper extends RequestMapper<Route, RouteRequest> {

    @Autowired
    private AirportService airportService;

    @Override
    @Mapping(target = "destination", ignore = true)
    @Mapping(target = "departure", ignore = true)
    public abstract Route convert(RouteRequest request);

    @AfterMapping
    public void setAirports(@MappingTarget Route route, RouteRequest request) {
        if (request == null) {
            return;
        }
        if (request.getDepartureId() != null) {
            route.setDeparture(airportService.retrieveById(request.getDepartureId()));
        }
        if (request.getDestinationId() != null) {
            route.setDestination(airportService.retrieveById(request.getDestinationId()));
        }
    }
}
