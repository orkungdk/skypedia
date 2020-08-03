package tr.com.ogedik.skypedia.entity;

import lombok.*;
import tr.com.ogedik.skypedia.model.Flight;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "airlineCompany")
    Set<FlightEntity> flight = new HashSet<>();

}
