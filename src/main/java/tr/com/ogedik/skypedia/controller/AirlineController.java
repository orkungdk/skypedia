package tr.com.ogedik.skypedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import tr.com.ogedik.skypedia.annotation.RestController;
import tr.com.ogedik.skypedia.constant.PathConstants;
import tr.com.ogedik.skypedia.mapper.request.AirlineCompanyMapper;
import tr.com.ogedik.skypedia.model.AirlineCompany;
import tr.com.ogedik.skypedia.rest.request.AirlineCompanyRequest;
import tr.com.ogedik.skypedia.service.AirlineCompanyService;

/**
 * @author orkungedik
 */
@RestController(PathConstants.AIRLINE)
public class AirlineController extends SkypediaController<AirlineCompanyRequest, AirlineCompany> {

    @Autowired
    public AirlineController(AirlineCompanyService service, AirlineCompanyMapper mapper) {
        super(service, mapper, AirlineController.class);
    }

//    @GetMapping
//    public SkypediaResponse search(@RequestParam(name = "name", required = false) String name,
//                                   @RequestParam(name = "shortName", required = false) String shortName) {
//        logger.info("A request has been received to search airline companies by name {} and shortName {}.", name, shortName);
//
//        return SkypediaResponseBuilder.build(service.search(name, shortName));
//    }
}
