package tr.com.ogedik.skypedia.entity;

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
public class RouteEntity extends SkypediaEntity {

    @ManyToOne
    @JoinColumn(name = "departure_id")
    private AirportEntity departure;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private AirportEntity destination;

    @Column
    private Long distance;

    @Column
    private int estimatedFlightTime;

    @OneToMany(mappedBy = "route")
    Set<FlightEntity> flight = new HashSet<>();
}
