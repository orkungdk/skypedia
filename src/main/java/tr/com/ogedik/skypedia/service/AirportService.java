package tr.com.ogedik.skypedia.service;

import tr.com.ogedik.skypedia.model.Airport;

import java.util.List;

/**
 * @author orkungedik
 */
public interface AirportService extends SkypediaService<Airport> {

    /**
     * Creates airport by the given request and persist the created airport into the database.
     *
     * @param airport to be created airport
     * @return created {@link Airport}
     */
    @Override
    Airport create(Airport airport);

    /**
     * Retrieves the airport by it's id
     *
     * @param id airports id
     * @return found {@link Airport}
     */
    @Override
    Airport retrieveById(Long id);

    /**
     * Search the airports by the given parameters in the {@code searchRequest}
     *
     * @param searchRequest search params
     * @return found airports
     */
    @Override
    List<Airport> search(Airport searchRequest);
}
