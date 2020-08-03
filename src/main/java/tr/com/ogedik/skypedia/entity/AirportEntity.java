package tr.com.ogedik.skypedia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.ogedik.skypedia.model.Location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author orkungedik
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirportEntity extends SkypediaEntity {

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="LOCATION_ID")
    private LocationEntity location;

    @Column
    private Integer flightCapacity;

}
