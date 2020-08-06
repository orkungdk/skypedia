package tr.com.ogedik.skypedia.mapper.request;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import tr.com.ogedik.skypedia.model.Booking;
import tr.com.ogedik.skypedia.rest.request.BookingRequest;
import tr.com.ogedik.skypedia.service.TicketService;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring")
public abstract class BookingMapper extends RequestMapper<Booking, BookingRequest> {

    @Autowired
    private TicketService ticketService;

    @Override
    @Mapping(target = "ticket", ignore = true)
    public abstract Booking convert(BookingRequest bookingRequest);

    @AfterMapping
    public void setTicket(@MappingTarget Booking booking, BookingRequest bookingRequest) {
        if (booking == null || bookingRequest == null || bookingRequest.getTicketId() == null) {
            return;
        }
        booking.setTicket(ticketService.retrieveById(bookingRequest.getTicketId()));
    }
}
