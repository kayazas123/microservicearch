package com.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AYAZ on 18/06/2018.
 */
@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{
}
