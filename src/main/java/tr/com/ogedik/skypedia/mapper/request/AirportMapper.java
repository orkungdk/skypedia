package tr.com.ogedik.skypedia.mapper.request;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import tr.com.ogedik.skypedia.model.Airport;
import tr.com.ogedik.skypedia.rest.request.AirportRequest;
import tr.com.ogedik.skypedia.service.LocationService;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring")
public abstract class AirportMapper extends RequestMapper<Airport, AirportRequest> {

    @Autowired
    protected LocationService locationService;

    @Override
    @Mapping(target= "location", ignore = true)
    public abstract Airport convert(AirportRequest request);

    @AfterMapping
    public void setLocation(@MappingTarget Airport airport, AirportRequest request) {
        if (request == null || request.getLocationId() == null) {
            return;
        }
        airport.setLocation(locationService.retrieveById(request.getLocationId()));
    }

    @Mapping(target = "locationId", ignore = true)
    @Override
    public abstract AirportRequest convert(Airport airport);
}
