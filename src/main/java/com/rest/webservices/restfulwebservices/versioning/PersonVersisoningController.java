package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AYAZ on 30/05/2018.
 */
@RestController
public class PersonVersisoningController {

    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return  new PersonV2(new Name("Ayaz","Ahmed"));
    }
}
