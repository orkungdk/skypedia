package tr.com.ogedik.skypedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import tr.com.ogedik.skypedia.annotation.RestController;
import tr.com.ogedik.skypedia.constant.PathConstants;
import tr.com.ogedik.skypedia.mapper.request.LocationMapper;
import tr.com.ogedik.skypedia.model.Location;
import tr.com.ogedik.skypedia.rest.request.LocationRequest;
import tr.com.ogedik.skypedia.service.LocationService;

/**
 * @author orkungedik
 */
@RestController(PathConstants.LOCATION)
public class LocationController extends SkypediaController<LocationRequest, Location> {

    @Autowired
    public LocationController(LocationService service, LocationMapper mapper) {
        super(service, mapper, LocationController.class);
    }
}
