package tr.com.ogedik.skypedia.service;

import tr.com.ogedik.skypedia.model.AirlineCompany;
import tr.com.ogedik.skypedia.rest.request.AirlineCompanyRequest;

import java.util.List;

/**
 * @author orkungedik
 */
public interface AirlineCompanyService extends SkypediaService<AirlineCompany> {

    /**
     * Creates airline company by the given request and persist the created airline company into the database.
     *
     * @param airlineCompany to be created airline company
     * @return created {@link AirlineCompany}
     */
    @Override
    AirlineCompany create(AirlineCompany airlineCompany);

    /**
     * Retrieves the airline company by it's id
     *
     * @param id airline company id
     * @return found {@link AirlineCompany}
     */
    @Override
    AirlineCompany retrieveById(Long id);

    /**
     * Search the airline companies by the given parameters in the {@code searchRequest}
     *
     * @param searchRequest search params
     * @return found airline companies
     */
    @Override
    List<AirlineCompany> search(AirlineCompany searchRequest);
}
