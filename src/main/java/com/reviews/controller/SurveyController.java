/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.reviews.models.Survey;
import com.reviews.repository.SurveyRepository;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author afrodeb
 */
@RestController
@RequestMapping("/api")
public class SurveyController {
 @Autowired
	SurveyRepository repository;
        @GetMapping("/survey")
	public List<Survey> getAllLocations() {
		System.out.println("Get all Surveys...");
		List<Survey> surveys = new ArrayList<>();
		repository.findAll().forEach(surveys::add); 
		return surveys;
	}
 
@PostMapping(value = "/survey/create")
public Survey postUser(@RequestBody Survey survey) {
		Survey _survey = repository.save(new Survey(null, survey.getName(),survey.getDescription(),null));
		return _survey;
	}
 
	@DeleteMapping("/survey/{id}")
	public ResponseEntity<String> deleteLocation(@PathVariable("id") long id) {
		System.out.println("Delete survey with ID = " + id + "...");
		repository.deleteById(id); 
		return new ResponseEntity<>("Survey has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/survey/delete")
	public ResponseEntity<String> deleteAllLocations() {
		System.out.println("Delete All Locations...");
		repository.deleteAll(); 
		return new ResponseEntity<>("All locations have been deleted!", HttpStatus.OK);
	}
 
	@GetMapping(value = "/survey/id/{id}")
	public List<Survey> findById(@PathVariable int id) {
		List<Survey> survey = repository.findById(id);
		return survey;
	}
 
	@PutMapping("/survey/{id}")
	public ResponseEntity<Survey> updateLocation(@PathVariable("id") long id, @RequestBody Survey survey) {
		System.out.println("Update survey with ID = " + id + "..."); 
		Optional<Survey> surveyData = repository.findById(id);
		if (surveyData.isPresent()) {
			Survey _survey = surveyData.get();
			_survey.setName(survey.getName());
                        _survey.setDescription(survey.getDescription());
			return new ResponseEntity<>(repository.save(_survey), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}   
}
