package tr.com.ogedik.skypedia.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author orkungedik
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirlineCompanyEntity extends SkypediaEntity {

    @Column
    private String name;

    @Column
    private String shortName;

}
