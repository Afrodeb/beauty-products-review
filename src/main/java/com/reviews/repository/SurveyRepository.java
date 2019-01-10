/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.repository;

import com.reviews.models.Survey;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author afrodeb
 */
public interface SurveyRepository extends CrudRepository<Survey,Long > {
      List<Survey> findById(int id); 
}
