/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.controller;

import com.reviews.models.SurveyAnswers;
import com.reviews.repository.SurveyAnswersRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SurveyAnswersController {
  @Autowired
	SurveyAnswersRepository repository;
        @GetMapping("/survey-answers")
	public List<SurveyAnswers> getAllSurveys() {
		System.out.println("Get all Surveys Answers...");
		List<SurveyAnswers> surveysAnswers = new ArrayList<>();
		repository.findAll().forEach(surveysAnswers::add); 
		return surveysAnswers;
	}
 
@PostMapping(value = "/survey-answers/create")
public SurveyAnswers postSurveyAnswer(@RequestBody SurveyAnswers surveyAnswers) {
		SurveyAnswers _surveyAnswers = repository.save(new SurveyAnswers(null, surveyAnswers.getSurveyQuestionId(),surveyAnswers.getAnswer(),null));
		return _surveyAnswers;
	}
 
	@DeleteMapping("/survey-answers/{id}")
	public ResponseEntity<String> deleteSurveyAnswer(@PathVariable("id") long id) {
		System.out.println("Delete survey answer with ID = " + id + "...");
		repository.deleteById(id); 
		return new ResponseEntity<>("Survey answer has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/survey-answers/delete")
	public ResponseEntity<String> deleteAllSurveyAnswers(@PathVariable("id") long id) {
		System.out.println("Delete All Locations...");
		repository.deleteAll(); 
		return new ResponseEntity<>("All locations have been deleted!", HttpStatus.OK);
	}
 
	@GetMapping(value = "/survey-answers/id/{id}")
	public List<SurveyAnswers> findById(@PathVariable int id) {
		List<SurveyAnswers> surveyAnswer = repository.findById(id);
		return surveyAnswer;
	}
 
	@PutMapping("/survey-answers/{id}")
	public ResponseEntity<SurveyAnswers> updateLocation(@PathVariable("id") long id, @RequestBody SurveyAnswers surveyAnswer) {
		System.out.println("Update survey answer with ID = " + id + "..."); 
		Optional<SurveyAnswers> surveyAnswerData = repository.findById(id);
		if (surveyAnswerData.isPresent()) {
			SurveyAnswers _surveyAnswer = surveyAnswerData.get();
			_surveyAnswer.setAnswer(surveyAnswer.getAnswer());                        
			return new ResponseEntity<>(repository.save(_surveyAnswer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}      
}
