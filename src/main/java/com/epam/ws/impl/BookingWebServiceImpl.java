package com.epam.ws.impl;

import com.epam.Common.domain.Person;
import com.epam.Common.domain.Ticket;
import com.epam.Common.exceptions.BookingException;
import com.epam.services.BookingService;
import com.epam.ws.BookingWebService;

import javax.jws.WebService;


/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */
@WebService(endpointInterface = "com.epam.ws.BookingWebService")
public class BookingWebServiceImpl implements BookingWebService {
    private BookingService bookingService = new BookingService();

    @Override
    public Ticket getTicketByBookingId(int bookingId) throws BookingException {
        return bookingService.getTicketByBookingId(bookingId);
    }

    @Override
    public int bookTicket(Ticket ticket, Person person) throws BookingException {
        return bookingService.bookTicket(ticket, person);
    }

    @Override
    public Ticket payTicket(Ticket ticket) throws BookingException {
        return bookingService.payTicket(ticket.getBookingId());
    }

    @Override
    public Ticket returnTicket(Ticket ticket) throws BookingException {
        return bookingService.returnTicket(ticket.getBookingId());

    }

    @Override
    public Ticket[] getAvailibletoBookingTickets() {
        Ticket[] tickets = new Ticket[bookingService.getAllTickets().size()];
        return bookingService.getAllTickets().toArray(tickets);
    }
}
