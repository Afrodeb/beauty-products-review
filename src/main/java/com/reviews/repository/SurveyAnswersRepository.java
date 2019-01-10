/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.repository;

import com.reviews.models.SurveyAnswers;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author afrodeb
 */
public interface SurveyAnswersRepository extends CrudRepository<SurveyAnswers, Long> {
     List<SurveyAnswers> findById(int id);  
}
