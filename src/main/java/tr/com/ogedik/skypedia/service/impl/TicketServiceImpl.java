package tr.com.ogedik.skypedia.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import tr.com.ogedik.skypedia.constant.TicketStatus;
import tr.com.ogedik.skypedia.entity.BookingEntity;
import tr.com.ogedik.skypedia.entity.FlightEntity;
import tr.com.ogedik.skypedia.entity.TicketEntity;
import tr.com.ogedik.skypedia.exception.ErrorMessage;
import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.exception.SkypediaException;
import tr.com.ogedik.skypedia.mapper.entity.TicketEntityMapper;
import tr.com.ogedik.skypedia.model.Ticket;
import tr.com.ogedik.skypedia.repository.BookingRepository;
import tr.com.ogedik.skypedia.repository.TicketRepository;
import tr.com.ogedik.skypedia.service.AuditLogService;
import tr.com.ogedik.skypedia.service.TicketService;
import tr.com.ogedik.skypedia.validation.facade.TicketValidationFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author orkungedik
 */
@Service
public class TicketServiceImpl implements TicketService {

    private static final Logger logger = LogManager.getLogger(TicketServiceImpl.class);

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TicketEntityMapper mapper;
    @Autowired
    private TicketValidationFacade validationFacade;
    @Autowired
    private AuditLogService auditLogService;

    /**
     * {@inheritDoc}
     *
     * @param ticket to be created ticket
     * @return List<{ @ link Ticket }>
     */
    @Override
    public List<Ticket> bulkCreate(Ticket ticket) {
        validationFacade.validateCreate(ticket);

        int numberOfSeats = ticket.getFlight().getNumberOfSeats();
        List<TicketEntity> ticketEntities = new ArrayList<>();

        for (int i = 0; i < numberOfSeats; i++) {
            TicketEntity ticketEntity = mapper.convert(ticket);
            ticket.setTicketStatus(TicketStatus.AVAILABLE);

            ticketEntities.add(ticketEntity);
        }

        List<TicketEntity> persistedEntities = ticketRepository.saveAll(ticketEntities);
        auditLogService.logCreate(persistedEntities);

        return (List<Ticket>) mapper.convert(ticketEntities);
    }

    /**
     * {@inheritDoc}
     *
     * @param ticket to be created ticket
     * @return {@link Ticket}
     */
    @Override
    public Ticket create(Ticket ticket) {
        validationFacade.validateCreate(ticket);

        TicketEntity ticketEntity = mapper.convert(ticket);
        ticket.setTicketStatus(TicketStatus.AVAILABLE);

        TicketEntity persistedTicket = ticketRepository.save(ticketEntity);
        auditLogService.logCreate(persistedTicket);

        return mapper.convert(persistedTicket);
    }

    /**
     * {@inheritDoc}
     *
     * @param id tickets id
     * @return {@link Ticket}
     */
    @Override
    public Ticket retrieveById(Long id) {
        TicketEntity foundTicket = ticketRepository.findById(id).orElseThrow(() -> initThrowable(id));

        return retrieveFulfilledTicket(foundTicket);
    }

    /**
     * Checks the ticket status and returns fulfilled ticket if the status is Available
     *
     * @param ticketEntity {@link TicketEntity}
     * @return {@link Ticket}
     */
    private Ticket retrieveFulfilledTicket(TicketEntity ticketEntity) {
        switch (ticketEntity.getTicketStatus()) {
            case AVAILABLE:
                return fulfillTicket(ticketEntity);
            case BOOKED:
                throw new SkypediaException(
                        new ErrorMessage(ErrorType.TICKED_BOOKED, "Ticket id is: " + ticketEntity.getId(), null));
            default:
                throw new SkypediaException(
                        new ErrorMessage(ErrorType.INTERNAL_ERROR, "Invalid ticket status", null));
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param searchRequest search params
     * @return List<{ @ link Ticket }>
     */
    @Override
    public List<Ticket> search(Ticket searchRequest) {
        TicketEntity entity = mapper.convert(searchRequest);
        List<TicketEntity> entities = ticketRepository.findAll(Example.of(entity));

        return entities.stream().map(o -> retrieveFulfilledTicket(o)).collect(Collectors.toList());
    }

    /**
     * Handles on the fly calculations and returns fulfilled {@link Ticket}
     *
     * @param foundTicket found ticket entity
     * @return {@link Ticket}
     */
    private Ticket fulfillTicket(TicketEntity foundTicket) {
        FlightEntity flightEntity = foundTicket.getFlight();
        List<BookingEntity> bookedEntities = bookingRepository.findAllByTicketFlightId(flightEntity.getId());

        Ticket ticket = mapper.convert(foundTicket);
        ticket.setPrice(
                calculateTicketPrice(flightEntity.getInitialPrice(), flightEntity.getNumberOfSeats(), bookedEntities.size()));

        return ticket;
    }

    /**
     * Calculates price according to capacity and initial price
     *
     * @param initialPrice        flight initial price
     * @param numberOfSeats       available seats in the plane
     * @param numberOfBookedSeats booked seats
     * @return calculated price
     */
    private Long calculateTicketPrice(Long initialPrice, Integer numberOfSeats, Integer numberOfBookedSeats) {
        int ratio = numberOfBookedSeats * 10 / numberOfBookedSeats;
        logger.info("{}% of tickets have been booked.", ratio);

        Long finalPrice = Long.valueOf(initialPrice + (initialPrice * ratio / 10));
        logger.info("Final price is calculated as {}", finalPrice);

        return finalPrice;
    }

    /**
     * Creates an exception in case of record is not found
     *
     * @param ticketId
     * @return {@link SkypediaException}
     */
    private SkypediaException initThrowable(Long ticketId) {
        return new SkypediaException(new ErrorMessage(ErrorType.RECORD_NOT_FOUND,
                "Ticket is not found for id " + ticketId, "ticketId"));
    }
}
