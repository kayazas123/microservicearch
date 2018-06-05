package com.rest.webservices.restfulwebservices.versioning;

/**
 * Created by AYAZ on 30/05/2018.
 */
public class PersonV1 {
    private String name;

    public PersonV1(String name) {
        this.name = name;
    }

    public PersonV1() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
