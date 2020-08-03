package tr.com.ogedik.skypedia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.exception.SkypediaException;
import tr.com.ogedik.skypedia.mapper.entity.LocationEntityMapper;
import tr.com.ogedik.skypedia.model.Location;
import tr.com.ogedik.skypedia.repository.LocationRepository;
import tr.com.ogedik.skypedia.service.AuditLogService;
import tr.com.ogedik.skypedia.service.LocationService;
import tr.com.ogedik.skypedia.util.CommonServiceUtils;
import tr.com.ogedik.skypedia.validation.facade.LocationValidationFacade;

import java.util.List;

/**
 * @author orkungedik
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationValidationFacade validationFacade;
    @Autowired
    private LocationEntityMapper mapper;
    @Autowired
    private LocationRepository repository;
    @Autowired
    private AuditLogService auditLogService;

    /**
     * {@inheritDoc}
     *
     * @param location to be created location
     * @return
     */
    @Override
    public Location create(Location location) {
        return (Location) CommonServiceUtils.createAuditable(location, validationFacade, mapper, repository, auditLogService);
    }

    /**
     * {@inheritDoc}
     *
     * @param id locations id
     * @return
     */
    @Override
    public Location retrieveById(Long id) {
        return (Location) CommonServiceUtils.retrieve(id, mapper, repository);

    }

    /**
     * {@inheritDoc}
     *
     * @param searchRequest search params
     * @return
     */
    @Override
    public List<Location> search(Location searchRequest) {
        if (searchRequest.getCountry() == null && searchRequest.getCity() == null) {
            throw new SkypediaException(ErrorType.NO_SEARCH_CRITERIA, "At least one search criteria must be provided.");
        }
        return CommonServiceUtils.search(searchRequest, mapper, repository);
    }
}
