package tr.com.ogedik.skypedia.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tr.com.ogedik.skypedia.constant.AuditLogType;
import tr.com.ogedik.skypedia.entity.SkypediaEntity;
import tr.com.ogedik.skypedia.entity.AuditLogEntity;
import tr.com.ogedik.skypedia.repository.AuditLogRepository;
import tr.com.ogedik.skypedia.service.AuditLogService;

import java.util.Collection;

/**
 * @author orkungedik
 */
@Async
@Service
public class AuditLogServiceImpl implements AuditLogService {

    private static final Logger LOGGER = LogManager.getLogger(AuditLogServiceImpl.class);

    @Autowired
    private AuditLogRepository repository;

    @Override
    public <T extends SkypediaEntity> void logCreate(T entity) {
        LOGGER.info("Created audit entity has been received. Values {}", entity);
        AuditLogEntity auditLogEntity = AuditLogEntity.builder()
                .target(entity.getClass().getSimpleName())
                .type(AuditLogType.CREATE)
                .at(entity.getCreatedAt())
                .by(entity.getCreatedBy())
                .build();
        repository.save(auditLogEntity);
    }

    @Override
    public <T extends SkypediaEntity> void logCreate(Collection<T> entities) {
        entities.stream().forEach(entity -> logCreate(entity));
    }

    @Override
    public <T extends SkypediaEntity> void logUpdate(T oldEntity, T newEntity) {
        LOGGER.info("Updated audit entity has been received. Old values {}, new values {}.", oldEntity, newEntity);
        AuditLogEntity auditLogEntity = AuditLogEntity.builder()
                .target(newEntity.getClass().getSimpleName())
                .type(AuditLogType.UPDATE)
                .at(newEntity.getUpdatedAt())
                .by(newEntity.getUpdatedBy())
                .build();
        repository.save(auditLogEntity);
    }
}
