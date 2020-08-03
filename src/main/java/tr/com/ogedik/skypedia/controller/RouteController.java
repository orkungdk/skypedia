package tr.com.ogedik.skypedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import tr.com.ogedik.skypedia.annotation.RestController;
import tr.com.ogedik.skypedia.constant.PathConstants;
import tr.com.ogedik.skypedia.mapper.request.RouteMapper;
import tr.com.ogedik.skypedia.model.Route;
import tr.com.ogedik.skypedia.rest.request.RouteRequest;
import tr.com.ogedik.skypedia.service.RouteService;

/**
 * @author orkungedik
 */
@RestController(PathConstants.ROUTE)
public class RouteController extends SkypediaController<RouteRequest, Route> {

    @Autowired
    public RouteController(RouteService routeService, RouteMapper routeMapper) {
        super(routeService, routeMapper, RouteController.class);
    }
}
