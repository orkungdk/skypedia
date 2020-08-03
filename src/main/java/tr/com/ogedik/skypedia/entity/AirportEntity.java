package tr.com.ogedik.skypedia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
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
public class AirportEntity extends SkypediaEntity {

    @Column
    private String name;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="LOCATION_ID")
    private LocationEntity location;

    @Column
    private Integer flightCapacity;

    @OneToMany(mappedBy = "destination")
    private Set<RouteEntity> destinations = new HashSet<>();

    @OneToMany(mappedBy = "departure")
    private Set<RouteEntity> departures = new HashSet<>();

    @JsonBackReference
    public LocationEntity getLocation() {
        return location;
    }
}
