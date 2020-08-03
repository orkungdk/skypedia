package tr.com.ogedik.skypedia.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import tr.com.ogedik.skypedia.model.Airport;

import javax.persistence.CascadeType;
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

    @ToString.Exclude
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<AirportEntity> airports;

    @JsonManagedReference
    public List<AirportEntity> getAirports() {
        return airports;
    }
}
