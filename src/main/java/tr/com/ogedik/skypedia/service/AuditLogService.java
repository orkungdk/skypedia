package tr.com.ogedik.skypedia.service;

import tr.com.ogedik.skypedia.entity.SkypediaEntity;

import java.util.Collection;

/**
 * @author orkungedik
 */
public interface AuditLogService {

    /**
     * Creates an audit log message on CREATE action
     *
     * @param entity to be logged entity
     * @param <T> audit log
     */
    <T extends SkypediaEntity> void logCreate(T entity);

    /**
     * Bulk creates an audit log message on CREATE action
     *
     * @param entity to be logged entity
     * @param <T> audit log
     */
    <T extends SkypediaEntity> void logCreate(Collection<T> entity);

    /**
     * Creates an audit log message on UPDATE action
     *
     * @param oldEntity instance of old entity
     * @param newEntity instance of new entity
     * @param <T> audit log
     */
    <T extends SkypediaEntity> void logUpdate(T oldEntity, T newEntity);
}
