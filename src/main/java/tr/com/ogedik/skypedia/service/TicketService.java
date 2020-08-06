package tr.com.ogedik.skypedia.service;

import tr.com.ogedik.skypedia.model.Ticket;

import java.util.List;

/**
 * @author orkungedik
 */
public interface TicketService extends SkypediaService<Ticket> {

    /**
     * Bulk creates tickets by the given request and persist the created ticket into the database.
     *
     * @param ticket to be created ticket
     * @return created {@link Ticket}
     */
    List<Ticket> bulkCreate(Ticket ticket);

    /**
     * Creates ticket by the given request and persist the created ticket into the database.
     *
     * @param ticket to be created ticket
     * @return created {@link Ticket}
     */
    @Override
    Ticket create(Ticket ticket);

    /**
     * Retrieves the ticket by it's id with on the fly calculations
     *
     * @param id tickets id
     * @return found {@link Ticket}
     */
    @Override
    Ticket retrieveById(Long id);

    /**
     * Search the tickets by the given parameters in the {@code searchRequest}
     *
     * @param searchRequest search params
     * @return found tickets
     */
    @Override
    List<Ticket> search(Ticket searchRequest);

}
