package com.epam.services;

import com.epam.Common.domain.Person;
import com.epam.Common.domain.Ticket;
import com.epam.Common.domain.enums.TicketState;
import com.epam.Common.exceptions.BookingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */
public class BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
    private static int count = 0;
    private TicketService ticketService = new TicketService();
    private List<Ticket> bookedTickets = new ArrayList<>();
    public BookingService() {
        Ticket ticket = new Ticket("Moscow", "Tula", new Date(), new Date(), 1100.0);
        ticket.setBookingId(generateBookId());
        bookedTickets.add(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketService.getTickets();
    }

    public int bookTicket(Ticket ticket, Person person) {
        if (ticketService.getTicketById(ticket.getTicketId()) == null) {
            logger.warn("Ticket with id = {} is booked allready or not exist", ticket.getTicketId());
            throw new BookingException("This Ticket is booked allready or not exist");
        }
        ticket.setBookingId(generateBookId());
        ticket.setTicketState(TicketState.BOOKED);
        ticket.setPerson(person);
        bookedTickets.add(ticket);
        ticketService.removeTicket(ticket.getTicketId());
        logger.info("Ticket with id = {} is successfully booked. BookingId = {}", ticket.getTicketId(), ticket.getBookingId());
        return ticket.getBookingId();
    }

    public Ticket getTicketByBookingId(int bookingId) {
        for (Ticket ticket : bookedTickets) {
            if (ticket.getBookingId() == bookingId) {
                return ticket;
            }
        }
        logger.warn("BookingId = {} is not exist in system", bookingId);
        return null;
    }

    public void payTicket(int bookingId) {
        Ticket ticket = getTicketByBookingId(bookingId);
        if (ticket.getTicketState().equals(TicketState.BOOKED)) {
            ticket.setTicketState(TicketState.PAID);
            logger.info("Ticket with bookingId = {} was successfully paid", bookingId);
        } else {
            throw new BookingException("This Ticket is booked allready or not exist");
        }
    }

    public void returnTicket(int bookingId) {
        Ticket ticket = getTicketByBookingId(bookingId);
        if (ticket == null) {
            throw new BookingException("This Ticket is booked allready or not exist");
        }
        ticket.setTicketState(TicketState.NOT_BOOKED);
        bookedTickets.remove(ticket);
        ticketService.addTicket(ticket);
        logger.info("Tisket with BookingId = {} was successfully returned", bookingId);
    }

    private int generateBookId() {
        return ++count;
    }
}
