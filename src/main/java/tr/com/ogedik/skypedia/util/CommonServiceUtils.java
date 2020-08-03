package tr.com.ogedik.skypedia.util;

import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Example;
import tr.com.ogedik.skypedia.entity.SkypediaEntity;
import tr.com.ogedik.skypedia.mapper.SkypediaMapper;
import tr.com.ogedik.skypedia.model.SkypediaModel;
import tr.com.ogedik.skypedia.repository.SkypediaRepository;
import tr.com.ogedik.skypedia.service.AuditLogService;
import tr.com.ogedik.skypedia.validation.facade.ValidationFacade;

import java.util.List;
import java.util.Optional;

/**
 * @author orkungedik
 */
@UtilityClass
public class CommonServiceUtils {

    private static final Logger LOGGER = LogManager.getLogger(CommonServiceUtils.class);

    /**
     * Search records by given model
     *
     * @param searchRequest {@link SkypediaModel}
     * @param mapper        {@link SkypediaMapper}
     * @param repository    {@link SkypediaRepository}
     * @return found {@link SkypediaModel} records
     */
    public static List search(SkypediaModel searchRequest, SkypediaMapper mapper, SkypediaRepository repository) {
        SkypediaEntity entity = (SkypediaEntity) mapper.convert(searchRequest);
        List<SkypediaEntity> entities = repository.findAll(Example.of(entity));

        return (List<SkypediaModel>) mapper.convert(entities);
    }

    /**
     * Retrieves records by the given id
     *
     * @param id         search parameter
     * @param mapper     {@link SkypediaMapper}
     * @param repository {@link SkypediaRepository}
     * @return {@link SkypediaModel}
     */
    public static SkypediaModel retrieveById(Long id, SkypediaMapper mapper, SkypediaRepository repository) {
        Optional<SkypediaEntity> searchResult = repository.findById(id);

        if (searchResult.isPresent()) {
            LOGGER.info("Record is found for id {}.", id);
            return mapper.convert(searchResult.get());
        } else {
            LOGGER.info("Record is not found for id {}", id);
            return null;
        }
    }

    /**
     * Creates a record and inserts an audit log as well
     *
     * @param model            {@link SkypediaModel}
     * @param validationFacade {@link ValidationFacade}
     * @param mapper           {@link SkypediaMapper}
     * @param repository       {@link SkypediaRepository}
     * @param auditLogService  {@link AuditLogService}
     * @return {@link SkypediaModel}
     */
    public static SkypediaModel createAuditable(SkypediaModel model, ValidationFacade validationFacade, SkypediaMapper mapper,
                                                SkypediaRepository repository, AuditLogService auditLogService) {
        validationFacade.validateCreate(model);
        SkypediaEntity persisted = persistRecord(model, mapper, repository);
        auditLogService.logCreate(persisted);

        return mapper.convert(persisted);
    }

    /**
     * Creates a record
     *
     * @param model            {@link SkypediaModel}
     * @param validationFacade {@link ValidationFacade}
     * @param mapper           {@link SkypediaMapper}
     * @param repository       {@link SkypediaRepository}
     * @return {@link SkypediaModel}
     */
    public static SkypediaModel create(SkypediaModel model, ValidationFacade validationFacade, SkypediaMapper mapper,
                                       SkypediaRepository repository) {
        validationFacade.validateCreate(model);
        SkypediaEntity persisted = persistRecord(model, mapper, repository);

        return mapper.convert(persisted);
    }

    /**
     * Maps from model to entity and persists to database
     *
     * @param model      {@link SkypediaModel}
     * @param mapper     {@link SkypediaMapper}
     * @param repository {@link SkypediaRepository}
     * @return {@link SkypediaEntity}
     */
    public static SkypediaEntity persistRecord(SkypediaModel model, SkypediaMapper mapper,
                                                SkypediaRepository repository) {
        SkypediaEntity entity = (SkypediaEntity) mapper.convert(model);
        SkypediaEntity persisted = (SkypediaEntity) repository.save(entity);
        LOGGER.info("{} has been persisted to database.", model.getClass().getSimpleName());

        return persisted;
    }
}
