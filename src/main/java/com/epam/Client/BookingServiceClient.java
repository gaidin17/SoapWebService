package com.epam.Client;

import com.epam.Common.domain.Person;
import com.epam.Common.domain.Ticket;
import com.epam.Common.parsers.ObjectConverter;
import com.epam.Common.parsers.impl.ObjectJsonConverterImpl;
import com.epam.ws.BookingWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */
public class BookingServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        ObjectConverter objectConverter = new ObjectJsonConverterImpl();
        URL url = new URL("http://localhost:8033/WebServiceTask/SOAP?wsdl");

        QName qname = new QName("http://impl.ws.epam.com/", "BookingWebServiceImplService");
        Service service = Service.create(url, qname);
        BookingWebService bookingWebService = service.getPort(BookingWebService.class);

        List<Ticket> ticketList = new ArrayList<>();
        String[] tickets = bookingWebService.getAvailibletoBookingTickets();
        for (String string : tickets) {
            Ticket ticket = (Ticket) objectConverter.deserialize(string, Ticket.class);
            ticketList.add(ticket);
            System.out.println(string);
            System.out.println(ticket);
        }
        Person person = new Person("Vasily", "Alibbabaevich", "Alibabaev", new Date());
        Integer bookingId = null;
        try {
            bookingId = bookingWebService.bookTicket(objectConverter.serialize(ticketList.get(0)), objectConverter.serialize(person));
            System.out.println(bookingId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Ticket ticket = bookingWebService.getTicketByBookingId(bookingId);
        boolean isPaid = bookingWebService.payTicket(objectConverter.serialize(ticket));
        System.out.println(isPaid);

        boolean isReturned = bookingWebService.returnTicket(objectConverter.serialize(ticket));
        System.out.println(isReturned);
    }
}
