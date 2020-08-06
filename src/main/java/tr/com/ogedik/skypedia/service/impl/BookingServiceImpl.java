package tr.com.ogedik.skypedia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.ogedik.skypedia.constant.TicketStatus;
import tr.com.ogedik.skypedia.entity.BookingEntity;
import tr.com.ogedik.skypedia.entity.TicketEntity;
import tr.com.ogedik.skypedia.mapper.entity.BookingEntityMapper;
import tr.com.ogedik.skypedia.model.Booking;
import tr.com.ogedik.skypedia.repository.BookingRepository;
import tr.com.ogedik.skypedia.repository.TicketRepository;
import tr.com.ogedik.skypedia.service.AuditLogService;
import tr.com.ogedik.skypedia.service.BookingService;
import tr.com.ogedik.skypedia.util.CommonServiceUtils;
import tr.com.ogedik.skypedia.validation.facade.BookingValidationFacade;

import java.util.List;

/**
 * @author orkungedik
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingEntityMapper mapper;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private BookingValidationFacade validationFacade;
    @Autowired
    private AuditLogService auditLogService;

    /**
     * {@inheritDoc}
     *
     * 1- Creates a booking entity and persists it.
     * 2- Update referenced ticket entity as BOOKED
     * 3- Calls audit log service
     * 4- Returns booking model
     *
     * @param booking to be created booking
     * @return {@link Booking}
     */
    @Override
    public Booking create(Booking booking) {
        validationFacade.validateCreate(booking);
        BookingEntity persisted = (BookingEntity) CommonServiceUtils.persistRecord(booking, mapper, bookingRepository);

        TicketEntity ticketEntity = persisted.getTicket();
        ticketEntity.setTicketStatus(TicketStatus.BOOKED);
        ticketRepository.save(ticketEntity);

        auditLogService.logCreate(persisted);

        return mapper.convert(persisted);
    }

    /**
     * {@inheritDoc}
     *
     * @param id bookings id
     * @return {@link Booking}
     */
    @Override
    public Booking retrieveById(Long id) {
        return (Booking) CommonServiceUtils.retrieveById(id, mapper, bookingRepository);
    }

    /**
     * {@inheritDoc}
     *
     * @param searchRequest search params
     * @return List<{ @ link Booking }>
     */
    @Override
    public List<Booking> search(Booking searchRequest) {
        return CommonServiceUtils.search(searchRequest, mapper, bookingRepository);
    }
}
