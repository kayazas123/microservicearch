package com.rest.webservices.restfulwebservices.exception;

import java.util.Date;

/**
 * Created by AYAZ on 26/05/2018.
 */
public class ExceptionResponse {

    //timestamp
    private Date timeStamp;
    //message
    private String message;
    //detail
    private String details;

    public ExceptionResponse(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
