package com.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by AYAZ on 30/05/2018.
 */
@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean sb = new SomeBean("Value1","Value2","Value3");

        SimpleBeanPropertyFilter sbpf = SimpleBeanPropertyFilter.filterOutAllExcept("value1","value2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBean",sbpf);

        MappingJacksonValue mapping = new MappingJacksonValue(sb);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveSomeBeanList(){
        return Arrays.asList(new SomeBean("Value1","Value1","Value1"),
                new SomeBean("Value2","Value2","Value2"));
    }
}
