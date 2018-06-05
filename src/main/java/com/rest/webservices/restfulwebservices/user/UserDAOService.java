package com.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by AYAZ on 26/05/2018.
 */
@Component
public class UserDAOService {

    private static List<User> userList = new ArrayList<>();

    private static Integer counter = 4;

    static{
        userList.add(new User(1,"Ayaz",new Date()));
        userList.add(new User(2,"Tahaseen",new Date()));
        userList.add(new User(3,"Ayaana",new Date()));
        userList.add(new User(4,"Zayan",new Date()));
    }

    public List<User> findAll(){
        return userList;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++counter);
        }
        userList.add(user);
        return user;
    }

    public User findOne(int d){
        List<User> filteredList = userList.stream().filter(user -> user.getId() == d).collect(Collectors.toList());
        if(filteredList.size() > 0)
            return filteredList.get(0);
        return null;
    }

    public User deleteById(int id){
        Iterator iterator = userList.iterator();
        while (iterator.hasNext()){
            User user = (User)iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
           }
        return null;
    }


}
