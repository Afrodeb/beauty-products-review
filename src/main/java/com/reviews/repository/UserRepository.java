/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.repository;

import com.reviews.models.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author afrodeb
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  
    /**
     *
     * @param id
     * @return
     */
    List<User> findById(int id);  
}

