package com.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AYAZ on 05/06/2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
}
