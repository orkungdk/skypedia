package tr.com.ogedik.skypedia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.ogedik.skypedia.model.Airport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author orkungedik
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationEntity extends SkypediaEntity {

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String latitude;

    @Column
    private String longitude;

    @OneToMany(mappedBy = "location")
    private List<AirportEntity> airports;

}
