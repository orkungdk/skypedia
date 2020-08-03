package tr.com.ogedik.skypedia.service;

import tr.com.ogedik.skypedia.model.Location;

import java.util.List;

/**
 * @author orkungedik
 */
public interface LocationService extends SkypediaService<Location> {

    /**
     * Creates location by the given request and persist the created location into the database.
     *
     * @param location to be created location
     * @return created {@link Location}
     */
    @Override
    Location create(Location location);

    /**
     * Retrieves the location by it's id
     *
     * @param id locations id
     * @return found {@link Location}
     */
    @Override
    Location retrieveById(Long id);

    /**
     * Search the locations by the given parameters in the {@code searchRequest}
     *
     * @param searchRequest search params
     * @return found locations
     */
    @Override
    List<Location> search(Location searchRequest);
}
