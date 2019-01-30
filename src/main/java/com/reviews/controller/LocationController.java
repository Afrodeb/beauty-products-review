/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.controller;

import com.reviews.models.Locations;
import com.reviews.repository.LocationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LocationController {
        @Autowired
	LocationRepository repository;
        @GetMapping("/location")
	public List<Locations> getAllLocations() {
		System.out.println("Get all Locations...");
		List<Locations> locations = new ArrayList<>();
		repository.findAll().forEach(locations::add); 
		return locations;
	}
 
@PostMapping(value = "/location/create")
public Locations postUser(@RequestBody Locations location) {
		Locations _location = repository.save(new Locations(null, location.getName(),null));
		return _location;
	}
 
	@DeleteMapping("/location/{id}")
	public ResponseEntity<String> deleteLocation(@PathVariable("id") long id) {
		System.out.println("Delete location with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/location/delete")
	public ResponseEntity<String> deleteAllLocations() {
		System.out.println("Delete All Locations...");
		repository.deleteAll(); 
		return new ResponseEntity<>("All locations have been deleted!", HttpStatus.OK);
	}
 
	@GetMapping(value = "location/id/{id}")
	public List<Locations> findById(@PathVariable int id) {
		List<Locations> locations = repository.findById(id);
		return locations;
	}
 
	@PutMapping("/location/{id}")
	public ResponseEntity<Locations> updateLocation(@PathVariable("id") long id, @RequestBody Locations location) {
		System.out.println("Update location with ID = " + id + "..."); 
		Optional<Locations> locationData = repository.findById(id);
		if (locationData.isPresent()) {
			Locations _location = locationData.get();
			_location.setName(location.getName());                                       			
			return new ResponseEntity<>(repository.save(_location), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

