package tr.com.ogedik.skypedia.service;

import tr.com.ogedik.skypedia.model.Booking;

import java.util.List;

/**
 * @author orkungedik
 */
public interface BookingService extends SkypediaService<Booking> {

    /**
     * Creates booking by the given request and persist the created booking into the database.
     *
     * @param booking to be created booking
     * @return created {@link Booking}
     */
    @Override
    Booking create(Booking booking);

    /**
     * Retrieves the booking by it's id
     *
     * @param id bookings id
     * @return found {@link Booking}
     */
    @Override
    Booking retrieveById(Long id);

    /**
     * Search the bookings by the given parameters in the {@code searchRequest}
     *
     * @param searchRequest search params
     * @return found bookings
     */
    @Override
    List<Booking> search(Booking searchRequest);
}
