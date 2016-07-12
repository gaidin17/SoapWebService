package com.epam.Common.exceptions;

import javax.xml.ws.WebFault;

/**
 * Created by Evgeny_Akulenko on 7/6/2016.
 */
@WebFault
public class BookingException extends Exception {

    private String message;

    public BookingException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
