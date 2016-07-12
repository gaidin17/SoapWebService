package com.epam.Client;

import com.epam.Common.domain.Person;
import com.epam.Common.domain.Ticket;
import com.epam.Common.exceptions.BookingException;
import com.epam.ws.BookingWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */
public class BookingServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8033/WebServiceTask/SOAP?wsdl");

        QName qname = new QName("http://impl.ws.epam.com/", "BookingWebServiceImplService");
        Service service = Service.create(url, qname);
        BookingWebService bookingWebService = service.getPort(BookingWebService.class);

        Ticket[] tickets = bookingWebService.getAvailibletoBookingTickets();
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }

        Person person = new Person("Vasily", "Alibbabaevich", "Alibabaev", new Date());
        try {
            int bookingId = bookingWebService.bookTicket(tickets[0], person);
            System.out.println(bookingId);

            Ticket ticket = bookingWebService.getTicketByBookingId(bookingId);

            ticket = bookingWebService.payTicket(ticket);
            System.out.println(ticket.getTicketState());

            ticket = bookingWebService.returnTicket(ticket);
            System.out.println(ticket.getTicketState());
        } catch (BookingException ex) {
            ex.printStackTrace();
        }
    }
}
