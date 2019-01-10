/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.reviews.models.UserLocation;
import com.reviews.repository.UserLocationRepository;
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
public class UserLocationController {
    @Autowired
	UserLocationRepository repository;
        @GetMapping("/user-location")
	public List<UserLocation> getAllUserLocations() {
		System.out.println("Get all locations...");
		List<UserLocation> userLocation = new ArrayList<>();
		repository.findAll().forEach(userLocation::add); 
		return userLocation;
	}
 
@PostMapping(value = "/user-location/create")
public UserLocation postUserLocation(@RequestBody UserLocation userLocation) {
		UserLocation _userLocation = repository.save(new UserLocation(null, userLocation.getUserId(),userLocation.getUserId(),null));
		return _userLocation;
	}
 
	@DeleteMapping("/user-location/{id}")
	public ResponseEntity<String> deleteUserLocation(@PathVariable("id") long id) {
		System.out.println("Delete survey question with ID = " + id + "...");
		repository.deleteById(id); 
		return new ResponseEntity<>("Survey question has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/user-location/delete")
	public ResponseEntity<String> deleteAllUserLocations(@PathVariable("id") long id) {
		System.out.println("Delete All Locations...");
		repository.deleteAll(); 
		return new ResponseEntity<>("All locations have been deleted!", HttpStatus.OK);
	}
 
	@GetMapping(value = "/user-location/id/{id}")
	public List<UserLocation> findById(@PathVariable int id) {
		List<UserLocation> userLocation = repository.findById(id);
		return userLocation;
	}
 
	@PutMapping("/user-location/{id}")
	public ResponseEntity<UserLocation> updateUserLocation(@PathVariable("id") long id, @RequestBody UserLocation userLocation) {
		System.out.println("Update user location with ID = " + id + "..."); 
		Optional<UserLocation> userLocationData = repository.findById(id);
		if (userLocationData.isPresent()) {
			UserLocation _userLocation = userLocationData.get();
			_userLocation.setUserId(userLocation.getUserId());
                        _userLocation.setLocationId(userLocation.getLocationId());
			return new ResponseEntity<>(repository.save(_userLocation), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}      
}
