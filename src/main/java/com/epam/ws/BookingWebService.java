package com.epam.ws;

/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */

import com.epam.Common.domain.Ticket;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BookingWebService {

    @WebMethod
    public Ticket getTicketByBookingId(int bookingId);

    @WebMethod
    public int bookTicket(String ticketString, String personString);

    @WebMethod
    public void payTicket(int bookingId);

    @WebMethod
    public void returnTicket(int bookingId);

    @WebMethod
    public String[] getAvailibletoBookingTickets();

}
