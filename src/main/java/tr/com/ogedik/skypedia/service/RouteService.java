package tr.com.ogedik.skypedia.service;

import tr.com.ogedik.skypedia.model.Route;

import java.util.List;

/**
 * @author orkungedik
 */
public interface RouteService extends SkypediaService<Route>{


    /**
     * Creates route by the given request and persist the created route into the database.
     *
     * @param route to be created route
     * @return created {@link Route}
     */
    @Override
    Route create(Route route);

    /**
     * Retrieves the route by it's id
     *
     * @param id routes id
     * @return found {@link Route}
     */
    @Override
    Route retrieveById(Long id);

    /**
     * Search the routes by the given parameters in the {@code searchRequest}
     *
     * @param searchRequest search params
     * @return found routes
     */
    @Override
    List<Route> search(Route searchRequest);
}
