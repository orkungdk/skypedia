package tr.com.ogedik.skypedia.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tr.com.ogedik.skypedia.constant.PathConstants;
import tr.com.ogedik.skypedia.exception.SkypediaException;
import tr.com.ogedik.skypedia.mapper.request.RequestMapper;
import tr.com.ogedik.skypedia.model.SkypediaModel;
import tr.com.ogedik.skypedia.rest.request.SkypediaRequest;
import tr.com.ogedik.skypedia.rest.response.SkypediaResponse;
import tr.com.ogedik.skypedia.rest.response.SkypediaResponseBuilder;
import tr.com.ogedik.skypedia.service.SkypediaService;
import tr.com.ogedik.skypedia.util.MetaUtils;

/**
 * This class is an abstraction of the all controllers in this application.
 *
 * @author orkungedik
 */
public abstract class SkypediaController<Request extends SkypediaRequest, M extends SkypediaModel> {

    protected final SkypediaService service;
    
    protected final RequestMapper mapper;
    
    protected final Logger logger;

    protected SkypediaController(SkypediaService service, RequestMapper mapper, Class clazz) {
        this.service = service;
        this.mapper = mapper;
        this.logger = LogManager.getLogger(clazz);
    }

    @GetMapping("/{id}")
    public SkypediaResponse getById(@PathVariable("id") Long id) {
        logger.info("A request has been received to retrieve by id");
        return SkypediaResponseBuilder.build(service.retrieveById(id));
    }

    @GetMapping
    public SkypediaResponse search(Request request) {
        logger.info("A request has been received to search by {}", request);
        M model = (M) mapper.convert(request);

        return SkypediaResponseBuilder.build(service.search(model));
    }

    @PostMapping
    public SkypediaResponse create(@RequestBody Request request,
            @RequestHeader(value = PathConstants.AUTH_HEADER, defaultValue = PathConstants.ANONYMOUS) String username) {
        logger.info("A request has been received to create {}", request.getClass().getSimpleName());
        M model = (M) mapper.convert(request);
        MetaUtils.fillMeta(model, username);

        return SkypediaResponseBuilder.build(service.create(model));
    }

    @ExceptionHandler
    public SkypediaResponse handle(SkypediaException e) {
        return SkypediaResponseBuilder.build(e.getErrors(), HttpStatus.valueOf(e.getHttpStatusCode()));
    }
}
