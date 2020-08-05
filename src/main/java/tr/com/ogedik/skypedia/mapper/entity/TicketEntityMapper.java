package tr.com.ogedik.skypedia.mapper.entity;

import org.mapstruct.Mapper;
import tr.com.ogedik.skypedia.entity.TicketEntity;
import tr.com.ogedik.skypedia.model.Ticket;

/**
 * @author orkungedik
 */
@Mapper(componentModel = "spring", uses = FlightEntityMapper.class)
public abstract class TicketEntityMapper extends EntityMapper<Ticket, TicketEntity> {
}
