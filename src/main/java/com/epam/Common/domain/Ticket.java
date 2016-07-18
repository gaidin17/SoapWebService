package com.epam.Common.domain;

import com.epam.Common.domain.enums.TicketState;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */
@XmlRootElement
public class Ticket {
    private static int count = 0;
    private int ticketId;
    private int bookingId;
    private String departureCity;
    private String destinationCity;
    private Date departureDate;
    private Date arrivalDate;
    private Double price;
    private TicketState ticketState;
    private Person person;

    public Ticket() {

    }

    public Ticket(String departureCity, String destinationCity, Date departureDate, Date arrivalDate, Double price) {
        this.ticketId = count++;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.ticketState = TicketState.NOT_BOOKED;
        this.price = price;
    }


    public static int getCount() {
        return count;
    }


    @XmlAttribute
    public int getTicketId() {
        return ticketId;
    }

    @XmlElement
    public int getBookingId() {
        return bookingId;
    }

    @XmlElement
    public String getDepartureCity() {
        return departureCity;
    }

    @XmlElement
    public String getDestinationCity() {
        return destinationCity;
    }

    @XmlElement
    public Date getDepartureDate() {
        return departureDate;
    }

    @XmlElement
    public Date getArrivalDate() {
        return arrivalDate;
    }

    @XmlElement
    public Double getPrice() {
        return price;
    }

    @XmlElement
    public TicketState getTicketState() {
        return ticketState;
    }

    @XmlElement
    public Person getPerson() {
        return person;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setTicketState(TicketState ticketState) {
        this.ticketState = ticketState;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
