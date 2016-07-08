package com.epam.ws.impl;

import com.epam.Common.domain.Person;
import com.epam.Common.domain.Ticket;
import com.epam.Common.parsers.ObjectConverter;
import com.epam.Common.parsers.impl.ObjectJsonConverterImpl;
import com.epam.services.BookingService;
import com.epam.ws.BookingWebService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */
@WebService(endpointInterface = "com.epam.ws.BookingWebService")
public class BookingWebServiceImpl implements BookingWebService {
    private BookingService bookingService = new BookingService();
    private ObjectConverter objectConverter = new ObjectJsonConverterImpl();

    @Override
    public Ticket getTicketByBookingId(int bookingId) {
        return bookingService.getTicketByBookingId(bookingId);
    }

    @Override
    public int bookTicket(String ticketString, String personString) {
        Ticket ticket = (Ticket) objectConverter.deserialize(ticketString, Ticket.class);
        Person person = (Person) objectConverter.deserialize(personString, Person.class);
        return bookingService.bookTicket(ticket, person);
    }

    @Override
    public void payTicket(int bookingId) {
        bookingService.payTicket(bookingId);
    }

    @Override
    public void returnTicket(int bookingId) {
        bookingService.returnTicket(bookingId);
    }

    @Override
    public String[] getAvailibletoBookingTickets() {
        List<String> ticketStrings = new ArrayList<>();
        for (Ticket ticket : bookingService.getAllTickets()) {
            ticketStrings.add(objectConverter.serialize(ticket));
        }
        return ticketStrings.toArray(new String[0]);
    }

}
