package com.epam.ws.publishers;

/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */
import javax.xml.ws.Endpoint;

import com.epam.ws.impl.BookingWebServiceImpl;

public class BookingWebServicePublisher {
    public static void main(String... args) {
        Endpoint.publish("http://localhost:1897/WebServiceTask/soap", new BookingWebServiceImpl());
    }
}