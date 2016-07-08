package com.epam.Common.domain;

import com.epam.Common.domain.enums.TicketState;

import java.util.Date;

/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */
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

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setTicketState(TicketState ticketState) {
        this.ticketState = ticketState;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public static int getCount() {
        return count;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Double getPrice() {
        return price;
    }

    public TicketState getTicketState() {
        return ticketState;
    }

    public Person getPerson() {
        return person;
    }
}
