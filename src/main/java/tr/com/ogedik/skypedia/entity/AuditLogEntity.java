package tr.com.ogedik.skypedia.entity;

import lombok.*;
import tr.com.ogedik.skypedia.constant.AuditLogType;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author orkungedik
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuditLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column
    private String target;
    @Enumerated
    @Column
    private AuditLogType type;
    @Column
    private LocalDateTime at;
    @Column
    private String by;

}
