package com.rest.webservices.restfulwebservices.versioning;

/**
 * Created by AYAZ on 30/05/2018.
 */
public class PersonV2 {

    private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    public PersonV2() {
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
