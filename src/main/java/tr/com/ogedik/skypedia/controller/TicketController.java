package tr.com.ogedik.skypedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tr.com.ogedik.skypedia.annotation.RestController;
import tr.com.ogedik.skypedia.constant.PathConstants;
import tr.com.ogedik.skypedia.mapper.request.TicketMapper;
import tr.com.ogedik.skypedia.model.Ticket;
import tr.com.ogedik.skypedia.rest.request.TicketRequest;
import tr.com.ogedik.skypedia.rest.response.SkypediaResponse;
import tr.com.ogedik.skypedia.rest.response.SkypediaResponseBuilder;
import tr.com.ogedik.skypedia.service.TicketService;

/**
 * @author orkungedik
 */
@RestController(PathConstants.TICKET)
public class TicketController extends SkypediaController<TicketRequest, Ticket> {

    @Autowired
    protected TicketController(TicketService service, TicketMapper mapper) {
        super(service, mapper, TicketController.class);
    }

    /**
     * Ticket bulk create controller. Creates ticket as many as available seats in that fly.
     *
     * @param request ticket creation request
     * @return {@link SkypediaResponse}
     */
    @PostMapping(PathConstants.BULK)
    public SkypediaResponse bulkCreate(@RequestBody TicketRequest request) {
        logger.info("A request has been received to bulk create ticket records for flight: {}", request.getFlightId());
        Ticket bulkTicket = (Ticket) mapper.convert(request);

        return SkypediaResponseBuilder.build(((TicketService)service).bulkCreate(bulkTicket));
    }
}
