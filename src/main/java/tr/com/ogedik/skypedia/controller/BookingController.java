package tr.com.ogedik.skypedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import tr.com.ogedik.skypedia.annotation.RestController;
import tr.com.ogedik.skypedia.constant.PathConstants;
import tr.com.ogedik.skypedia.mapper.request.BookingMapper;
import tr.com.ogedik.skypedia.model.Booking;
import tr.com.ogedik.skypedia.rest.request.BookingRequest;
import tr.com.ogedik.skypedia.service.BookingService;

/**
 * @author orkungedik
 */
@RestController(PathConstants.BOOKING)
public class BookingController extends SkypediaController<BookingRequest, Booking> {

    @Autowired
    protected BookingController(BookingService service, BookingMapper mapper) {
        super(service, mapper, BookingController.class);
    }
}
