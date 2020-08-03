package tr.com.ogedik.skypedia.mapper.request;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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
    @Mapping(target= "location", expression = "java(locationService.retrieveById(request.getLocationId()))")
    public abstract Airport convert(AirportRequest request);

    @Mapping(target = "locationId", ignore = true)
    @Override
    public abstract AirportRequest convert(Airport airport);
}
