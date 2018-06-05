package com.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AYAZ on 26/05/2018.
 */
//Configuration
    @Configuration
//Enable Swagger
    @EnableSwagger2
    @RestController
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Ayaz Ahmed", "http://www.ayazahmed.co.za", "kayazas@gmail.com");
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API title",
            "Awesome API Descr", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0");
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json","application/xml"));

    //Bean - Docket
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
    //Swagger 2

}
