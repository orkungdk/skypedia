package tr.com.ogedik.skypedia.mapper.entity;

import org.mapstruct.Mapper;
import tr.com.ogedik.skypedia.entity.AirlineCompanyEntity;
import tr.com.ogedik.skypedia.model.AirlineCompany;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring")
public abstract class AirlineCompanyEntityMapper extends EntityMapper<AirlineCompany, AirlineCompanyEntity> {
}
