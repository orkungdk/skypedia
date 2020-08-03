package tr.com.ogedik.skypedia.model;

import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.skypedia.constant.AuditLogType;

import java.time.LocalDateTime;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class AuditLog {

    private Long id;

    private String target;

    private AuditLogType type;

    private LocalDateTime at;

    private String by;

}
