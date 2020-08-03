package tr.com.ogedik.skypedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.ogedik.skypedia.entity.AuditLogEntity;

/**
 * @author orkungedik
 */
@Repository
public interface AuditLogRepository extends JpaRepository<AuditLogEntity, Long> {
}
