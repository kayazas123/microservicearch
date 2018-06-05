package com.rest.webservices.restfulwebservices.user;


import com.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by AYAZ on 26/05/2018.
 */
@RestController
public class UserResource {

    @Autowired
    private UserDAOService userDAO;

    //retrieveAllUsers
    @GetMapping(path = "/users")
    public List<User> getUsers(){
        return userDAO.findAll();
    }

    //retrieveUser(int id)
    @GetMapping(path = "/users/{id}")
    public Resource<User> getUser(@PathVariable int id){
        final User user = userDAO.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("User %d not found",id));
        }

        Resource<User> resource = new Resource<>(user);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    // input details of user
    // output - CREATED and Return the created URI
    @PostMapping(path = "/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        User createdUser = userDAO.save(user);
        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        //final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        User user = userDAO.deleteById(id);
        if(user == null){
            throw new UserNotFoundException(String.format("User %d not found",id));
        }
    }
}
