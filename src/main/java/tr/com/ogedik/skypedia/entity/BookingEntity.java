package tr.com.ogedik.skypedia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author orkungedik
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingEntity extends SkypediaEntity {

    @OneToOne
    @JoinColumn(name = "ticket")
    private TicketEntity ticket;

    @Column
    private Long price;

    @Column
    private String cardNumber;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;
}
