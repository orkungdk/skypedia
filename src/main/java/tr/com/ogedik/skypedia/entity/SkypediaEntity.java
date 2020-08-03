package tr.com.ogedik.skypedia.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * This is an abstract entity class.
 *
 * @implSpec All entities in the project needs to be extended to this class to prevent code duplication.
 *           All entities needs to have meta information and an identifier
 * @author orkungedik
 */
@MappedSuperclass
@Getter
@Setter
public class SkypediaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column
    private LocalDateTime createdAt;

    @Column
    private String createdBy;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private String updatedBy;

}