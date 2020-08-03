package tr.com.ogedik.skypedia.mapper.entity;

import org.mapstruct.Mapper;
import tr.com.ogedik.skypedia.entity.RouteEntity;
import tr.com.ogedik.skypedia.model.Route;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring")
public abstract class RouteEntityMapper extends EntityMapper<Route, RouteEntity> {
}
