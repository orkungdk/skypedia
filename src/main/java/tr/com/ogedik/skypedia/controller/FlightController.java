package tr.com.ogedik.skypedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import tr.com.ogedik.skypedia.annotation.RestController;
import tr.com.ogedik.skypedia.constant.PathConstants;
import tr.com.ogedik.skypedia.mapper.request.FlightMapper;
import tr.com.ogedik.skypedia.model.Flight;
import tr.com.ogedik.skypedia.rest.request.FlightRequest;
import tr.com.ogedik.skypedia.service.FlightService;

/**
 * @author orkungedik
 */
@RestController(PathConstants.FLIGHT)
public class FlightController extends SkypediaController<FlightRequest, Flight> {

    @Autowired
    protected FlightController(FlightService service, FlightMapper mapper) {
        super(service, mapper, FlightController.class);
    }
}
