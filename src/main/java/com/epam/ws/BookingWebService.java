package com.epam.ws;

/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */

import com.epam.Common.domain.Person;
import com.epam.Common.domain.Ticket;
import com.epam.Common.exceptions.BookingException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BookingWebService {

    @WebMethod
    public Ticket getTicketByBookingId(int bookingId) throws BookingException;

    @WebMethod
    public int bookTicket(Ticket ticket, Person person) throws BookingException;

    @WebMethod
    public Ticket payTicket(Ticket ticket) throws BookingException;

    @WebMethod
    public Ticket returnTicket(Ticket ticket) throws BookingException;

    @WebMethod
    public Ticket[] getAvailibletoBookingTickets();

}
