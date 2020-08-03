package tr.com.ogedik.skypedia.service;

import tr.com.ogedik.skypedia.model.Flight;

import java.util.List;

/**
 * @author orkungedik
 */
public interface FlightService extends SkypediaService<Flight> {

    /**
     * Creates flight by the given request and persist the created flight into the database.
     *
     * @param flight to be created flight
     * @return created {@link Flight}
     */
    @Override
    Flight create(Flight flight);

    /**
     * Retrieves the flight by it's id
     *
     * @param id flights id
     * @return found {@link Flight}
     */
    @Override
    Flight retrieveById(Long id);

    /**
     * Search the flights by the given parameters in the {@code searchRequest}
     *
     * @param searchRequest search params
     * @return found flights
     */
    @Override
    List<Flight> search(Flight searchRequest);
}
