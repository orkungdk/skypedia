package tr.com.ogedik.skypedia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.ogedik.skypedia.constant.TicketStatus;

import javax.persistence.*;

/**
 * @author orkungedik
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntity extends SkypediaEntity {

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flight;

    @Column
    @Enumerated
    private TicketStatus ticketStatus;

    @OneToOne(mappedBy = "ticket")
    private BookingEntity booking;

}
