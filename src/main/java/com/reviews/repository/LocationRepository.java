/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.repository;

import com.reviews.models.Locations;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author afrodeb
 */
public interface LocationRepository extends CrudRepository<Locations, Long>{
    List<Locations> findById(int id);  
}
