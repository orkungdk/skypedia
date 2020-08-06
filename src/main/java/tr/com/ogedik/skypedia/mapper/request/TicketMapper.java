package tr.com.ogedik.skypedia.mapper.request;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import tr.com.ogedik.skypedia.model.Ticket;
import tr.com.ogedik.skypedia.rest.request.TicketRequest;
import tr.com.ogedik.skypedia.service.FlightService;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring")
public abstract class TicketMapper extends RequestMapper<Ticket, TicketRequest> {

    @Autowired
    private FlightService flightService;

    @Override
    public Ticket convert(TicketRequest request) {
        if (request == null) {
            return null;
        }
        Ticket ticket = new Ticket();
        ticket.setFlight(flightService.retrieveById(request.getFlightId()));

        return ticket;
    }
}
