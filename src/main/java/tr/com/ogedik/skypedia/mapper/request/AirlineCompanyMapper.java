package tr.com.ogedik.skypedia.mapper.request;

/**
 * @author orkungedik
 */

import org.mapstruct.Mapper;
import tr.com.ogedik.skypedia.model.AirlineCompany;
import tr.com.ogedik.skypedia.rest.request.AirlineCompanyRequest;

@Mapper(componentModel = "spring")
public abstract class AirlineCompanyMapper extends RequestMapper<AirlineCompany, AirlineCompanyRequest> {
}
