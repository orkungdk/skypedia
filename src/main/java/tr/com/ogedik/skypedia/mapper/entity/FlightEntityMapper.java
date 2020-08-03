package tr.com.ogedik.skypedia.mapper.entity;

import org.mapstruct.Mapper;
import tr.com.ogedik.skypedia.entity.FlightEntity;
import tr.com.ogedik.skypedia.model.Flight;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring")
public abstract class FlightEntityMapper extends EntityMapper<Flight, FlightEntity> {
}
