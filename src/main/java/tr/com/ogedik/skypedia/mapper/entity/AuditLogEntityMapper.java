package tr.com.ogedik.skypedia.mapper.entity;

import org.mapstruct.Mapper;
import tr.com.ogedik.skypedia.entity.AuditLogEntity;
import tr.com.ogedik.skypedia.model.AuditLog;

/**
 * @implNote This class is an exception. Therefore, it does not implement generic mapper.
 * @see EntityMapper
 *
 *
 * @author orkungedik
 */
@Mapper
public abstract class AuditLogEntityMapper {

    /**
     * Converts from {@link AuditLogEntity} to {@link AuditLog}
     *
     * @param auditLogEntity mapping source
     * @return mapping target}
     */
    public abstract AuditLog convert(AuditLogEntity auditLogEntity);

    /**
     * Converts from {@link AuditLog} to {@link AuditLogEntity}
     *
     * @param auditLog mapping source
     * @return mapping target
     */
    public abstract AuditLogEntity convert(AuditLog auditLog);

}
