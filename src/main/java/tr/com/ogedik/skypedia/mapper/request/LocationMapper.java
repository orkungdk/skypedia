package tr.com.ogedik.skypedia.mapper.request;

import org.mapstruct.Mapper;
import tr.com.ogedik.skypedia.model.Location;
import tr.com.ogedik.skypedia.rest.request.LocationRequest;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring")
public abstract class LocationMapper extends RequestMapper<Location, LocationRequest>{
}
