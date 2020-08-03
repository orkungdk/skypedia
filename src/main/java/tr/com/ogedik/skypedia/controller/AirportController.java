package tr.com.ogedik.skypedia.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import tr.com.ogedik.skypedia.annotation.RestController;
import tr.com.ogedik.skypedia.constant.PathConstants;
import tr.com.ogedik.skypedia.mapper.request.AirportMapper;
import tr.com.ogedik.skypedia.mapper.request.RequestMapper;
import tr.com.ogedik.skypedia.model.Airport;
import tr.com.ogedik.skypedia.rest.request.AirportRequest;
import tr.com.ogedik.skypedia.rest.response.SkypediaResponse;
import tr.com.ogedik.skypedia.service.AirportService;
import tr.com.ogedik.skypedia.service.SkypediaService;

/**
 * @author orkungedik
 */
@RestController(PathConstants.AIRPORT)
public class AirportController extends SkypediaController<AirportRequest, Airport> {

    protected static final Logger LOGGER = LogManager.getLogger(AirportController.class);

    @Autowired
    protected AirportController(AirportService service, AirportMapper mapper) {
        super(service, mapper, AirportController.class);
    }
}
