package tr.com.ogedik.skypedia.mapper.entity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tr.com.ogedik.skypedia.entity.LocationEntity;
import tr.com.ogedik.skypedia.model.Location;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring", uses = AirportEntityMapper.class)
public abstract class LocationEntityMapper extends EntityMapper<Location, LocationEntity> {
}
