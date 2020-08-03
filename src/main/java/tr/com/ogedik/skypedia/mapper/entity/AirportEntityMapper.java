package tr.com.ogedik.skypedia.mapper.entity;

import org.mapstruct.Mapper;
import tr.com.ogedik.skypedia.entity.AirportEntity;
import tr.com.ogedik.skypedia.model.Airport;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring")
public abstract class AirportEntityMapper extends EntityMapper<Airport, AirportEntity> {
}
