/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.reviews.models.SurveyQuestions;
import com.reviews.repository.SurveyQuestionsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author afrodeb
 */
@RestController
@RequestMapping("/api")
public class SurveyQuestionsController {
     @Autowired
	SurveyQuestionsRepository repository;
     @RequestMapping("/survey-questions/survey/{id}")	
     public List<SurveyQuestions> getAllSurveyQuestions(@PathVariable int id) {	
                System.out.println("Get all Surveys Answers...");
		List<SurveyQuestions> surveysQuestions = new ArrayList<>();
                        
		//repository.findAll().forEach(surveysQuestions::add); 	
                return repository.getAllSurveyQuestions(id);
	}
 
@PostMapping(value = "/survey-questions/create")
public SurveyQuestions postSurveyAnswer(@RequestBody SurveyQuestions surveysQuestions) {
		SurveyQuestions _surveysQuestions = repository.save(new SurveyQuestions(null, surveysQuestions.getSurveyId(),surveysQuestions.getQuestion(),null));
		return _surveysQuestions;
	}
 
	@DeleteMapping("/survey-questions/{id}")
	public ResponseEntity<String> deleteSurveyQuestion(@PathVariable("id") long id) {
		System.out.println("Delete survey question with ID = " + id + "...");
		repository.deleteById(id); 
		return new ResponseEntity<>("Survey question has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/survey-questions/delete")
	public ResponseEntity<String> deleteAllSurveyQuestions(@PathVariable("id") long id) {
		System.out.println("Delete All Locations...");
		repository.deleteAll(); 
		return new ResponseEntity<>("All locations have been deleted!", HttpStatus.OK);
	}
 
	@GetMapping(value = "/survey-questions/id/{id}")
	public List<SurveyQuestions> findById(@PathVariable int id) {
		List<SurveyQuestions> surveyQuestion = repository.findById(id);
		return surveyQuestion;
	}
 
	@PutMapping("/survey-questions/{id}")
	public ResponseEntity<SurveyQuestions> updateLocation(@PathVariable("id") long id, @RequestBody SurveyQuestions surveyQuestion) {
		System.out.println("Update survey answer with ID = " + id + "..."); 
		Optional<SurveyQuestions> surveyQuestionData = repository.findById(id);
		if (surveyQuestionData.isPresent()) {
			SurveyQuestions _surveyQuestion = surveyQuestionData.get();
			_surveyQuestion.setQuestion(surveyQuestion.getQuestion());                        
			return new ResponseEntity<>(repository.save(_surveyQuestion), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}      
}
