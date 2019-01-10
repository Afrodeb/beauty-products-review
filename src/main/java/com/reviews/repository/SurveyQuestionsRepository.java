/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.repository;

import com.reviews.models.SurveyQuestions;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author afrodeb
 */
public interface SurveyQuestionsRepository extends CrudRepository<SurveyQuestions, Long> {
List<SurveyQuestions> findById(int id);      
@Query("SELECT s FROM SurveyQuestions s WHERE s.surveyId=:id")
List<SurveyQuestions> getAllSurveyQuestions(@Param("id")int id);
//surveyQuestions=find(@Param("id") id);
}
