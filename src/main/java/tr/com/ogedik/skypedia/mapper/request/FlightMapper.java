package tr.com.ogedik.skypedia.mapper.request;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import tr.com.ogedik.skypedia.model.Flight;
import tr.com.ogedik.skypedia.rest.request.FlightRequest;
import tr.com.ogedik.skypedia.service.AirlineCompanyService;
import tr.com.ogedik.skypedia.service.RouteService;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring")
public abstract class FlightMapper extends RequestMapper<Flight, FlightRequest> {

    @Autowired
    private RouteService routeService;
    @Autowired
    private AirlineCompanyService airlineCompanyService;

    @Override
    @Mapping(target = "route", ignore = true)
    @Mapping(target = "airlineCompany", ignore = true)
    public abstract Flight convert(FlightRequest request);

    @AfterMapping
    public void fulfillFlight(@MappingTarget Flight flight, FlightRequest request) {
        if (request == null) {
            return;
        }
        if (request.getAirlineCompanyId() != null) {
            flight.setAirlineCompany(airlineCompanyService.retrieveById(request.getAirlineCompanyId()));
        }
        if (request.getRouteId() != null) {
            flight.setRoute(routeService.retrieveById(request.getRouteId()));
        }
    }
}
