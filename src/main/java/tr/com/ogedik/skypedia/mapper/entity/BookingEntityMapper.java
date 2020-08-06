package tr.com.ogedik.skypedia.mapper.entity;

import org.mapstruct.Mapper;
import tr.com.ogedik.skypedia.entity.BookingEntity;
import tr.com.ogedik.skypedia.model.Booking;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring", uses = TicketEntityMapper.class)
public abstract class BookingEntityMapper extends EntityMapper<Booking, BookingEntity> {
}
