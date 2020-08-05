package tr.com.ogedik.skypedia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author orkungedik
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightEntity extends SkypediaEntity {

    @ManyToOne
    @JoinColumn(name = "airlineCompany_id")
    private AirlineCompanyEntity airlineCompany;

    @Column
    private Integer numberOfSeats;

    @Column
    private Long initialPrice;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private RouteEntity route;

    @Column
    private LocalDateTime departureAt;

    @OneToMany(mappedBy = "flight")
    private Set<TicketEntity> tickets;
}
