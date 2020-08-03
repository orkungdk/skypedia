package tr.com.ogedik.skypedia.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.ogedik.skypedia.mapper.entity.AirportEntityMapper;
import tr.com.ogedik.skypedia.model.Airport;
import tr.com.ogedik.skypedia.repository.AirportRepository;
import tr.com.ogedik.skypedia.service.AirportService;
import tr.com.ogedik.skypedia.service.AuditLogService;
import tr.com.ogedik.skypedia.util.CommonServiceUtils;
import tr.com.ogedik.skypedia.validation.facade.AirportValidationFacade;

import java.util.List;

/**
 * @author orkungedik
 */
@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportValidationFacade validationFacade;
    @Autowired
    private AirportEntityMapper mapper;
    @Autowired
    private AirportRepository repository;
    @Autowired
    private AuditLogService auditLogService;

    @Override
    public Airport create(Airport airport) {
        return (Airport) CommonServiceUtils.createAuditable(airport, validationFacade, mapper, repository, auditLogService);
    }

    @Override
    public Airport retrieveById(Long id) {
        return (Airport) CommonServiceUtils.retrieve(id, mapper, repository);
    }

    @Override
    public List<Airport> search(Airport searchRequest) {
        return CommonServiceUtils.search(searchRequest, mapper, repository);
    }
}
