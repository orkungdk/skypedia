package tr.com.ogedik.skypedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import tr.com.ogedik.skypedia.annotation.RestController;
import tr.com.ogedik.skypedia.constant.PathConstants;
import tr.com.ogedik.skypedia.mapper.request.AirportMapper;
import tr.com.ogedik.skypedia.model.Airport;
import tr.com.ogedik.skypedia.rest.request.AirportRequest;
import tr.com.ogedik.skypedia.service.AirportService;

/**
 * @author orkungedik
 */
@RestController(PathConstants.AIRPORT)
public class AirportController extends SkypediaController<AirportRequest, Airport> {

    @Autowired
    protected AirportController(AirportService service, AirportMapper mapper) {
        super(service, mapper, AirportController.class);
    }
}
