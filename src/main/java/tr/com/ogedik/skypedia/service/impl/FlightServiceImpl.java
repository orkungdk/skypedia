package tr.com.ogedik.skypedia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.ogedik.skypedia.mapper.entity.FlightEntityMapper;
import tr.com.ogedik.skypedia.model.Flight;
import tr.com.ogedik.skypedia.repository.FlightRepository;
import tr.com.ogedik.skypedia.service.AuditLogService;
import tr.com.ogedik.skypedia.service.FlightService;
import tr.com.ogedik.skypedia.util.CommonServiceUtils;
import tr.com.ogedik.skypedia.validation.facade.FlightValidationFacade;

import java.util.List;

/**
 * @author orkungedik
 */
@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightValidationFacade validationFacade;
    @Autowired
    private FlightEntityMapper mapper;
    @Autowired
    private FlightRepository repository;
    @Autowired
    private AuditLogService auditLogService;

    @Override
    public Flight create(Flight flight) {
        return (Flight) CommonServiceUtils.createAuditable(flight,validationFacade, mapper, repository, auditLogService);
    }

    @Override
    public Flight retrieveById(Long id) {
        return (Flight) CommonServiceUtils.retrieveById(id, mapper, repository);
    }

    @Override
    public List<Flight> search(Flight searchRequest) {
        return CommonServiceUtils.search(searchRequest, mapper, repository);
    }
}
