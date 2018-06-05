package com.rest.webservices.restfulwebservices.helloworld;

/**
 * Created by AYAZ on 26/05/2018.
 */
public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String s) {
        this.message = s;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
