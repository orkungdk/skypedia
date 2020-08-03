package tr.com.ogedik.skypedia.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.exception.SkypediaException;
import tr.com.ogedik.skypedia.mapper.entity.AirlineCompanyEntityMapper;
import tr.com.ogedik.skypedia.model.AirlineCompany;
import tr.com.ogedik.skypedia.repository.AirlineCompanyRepository;
import tr.com.ogedik.skypedia.service.AirlineCompanyService;
import tr.com.ogedik.skypedia.service.AuditLogService;
import tr.com.ogedik.skypedia.util.CommonServiceUtils;
import tr.com.ogedik.skypedia.validation.facade.AirlineCompanyValidationFacade;

import java.util.List;

/**
 * @author orkungedik
 */
@Service
public class AirlineCompanyServiceImpl implements AirlineCompanyService {

    private static final Logger LOGGER = LogManager.getLogger(AirlineCompanyServiceImpl.class);

    @Autowired
    private AirlineCompanyValidationFacade validationFacade;
    @Autowired
    private AirlineCompanyEntityMapper mapper;
    @Autowired
    private AirlineCompanyRepository repository;
    @Autowired
    private AuditLogService auditLogService;

    /**
     * {@inheritDoc}
     *
     * @param airlineCompany to be created airline company
     * @return created {@link AirlineCompany}
     */
    @Override
    @Transactional
    public AirlineCompany create(AirlineCompany airlineCompany) {
        return (AirlineCompany) CommonServiceUtils.createAuditable(airlineCompany, validationFacade, mapper, repository, auditLogService);
    }

    /**
     * {@inheritDoc}
     *
     * @param id airline company id
     * @return {@link AirlineCompany}
     */
    @Override
    public AirlineCompany retrieveById(Long id) {
        return (AirlineCompany) CommonServiceUtils.retrieveById(id, mapper, repository);
    }

    /**
     * {@inheritDoc}
     *
     * @param searchRequest search params
     * @return List<{@link AirlineCompany}>
     */
    @Override
    public List<AirlineCompany> search(AirlineCompany searchRequest) {
        if (searchRequest.getName() == null && searchRequest.getShortName() == null) {
            throw new SkypediaException(ErrorType.NO_SEARCH_CRITERIA, "At least one search criteria must be provided.");
        }

        return CommonServiceUtils.search(searchRequest, mapper, repository);
    }
}
