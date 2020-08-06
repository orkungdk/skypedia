package tr.com.ogedik.skypedia.repository;

import org.springframework.stereotype.Repository;
import tr.com.ogedik.skypedia.entity.BookingEntity;

import java.util.List;

/**
 * @author orkungedik
 */
@Repository
public interface BookingRepository extends SkypediaRepository<BookingEntity> {

    List<BookingEntity> findAllByTicketFlightId(Long ticketId);
}
