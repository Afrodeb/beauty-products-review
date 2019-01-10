/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.controller;
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
import com.reviews.models.User;
import com.reviews.repository.UserRepository;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
/**
 *
 * @author afrodeb
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
        @Autowired
	UserRepository repository;
        @GetMapping("/user")
	public List<User> getAllUsers() {
		System.out.println("Get all Customers...");
		List<User> users = new ArrayList<>();
		repository.findAll().forEach(users::add); 
		return users;
	}
 
@PostMapping(value = "/user/create")
public User postUser(@RequestBody User user) {
/*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
Validator validator = factory.getValidator();
Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
if (constraintViolations.size() > 0 ) {
System.out.println("Constraint Violations occurred..");
for (ConstraintViolation<User> contraints : constraintViolations) {
System.out.println(contraints.getRootBeanClass().getSimpleName()+
"." + contraints.getPropertyPath() + " " + contraints.getMessage());
  }
}*/
		User _user = repository.save(new User(user.getFullname(), user.getEmail(),user.getPhone(),user.getPassword()));
		return _user;
	}
 
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/user/delete")
	public ResponseEntity<String> deleteAllUsers() {
		System.out.println("Delete All Customers...");
		repository.deleteAll(); 
		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
	}
 
	@GetMapping(value = "user/id/{age}")
	public List<User> findById(@PathVariable int id) {
		List<User> users = repository.findById(id);
		return users;
	}
 
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		System.out.println("Update Customer with ID = " + id + "..."); 
		Optional<User> userData = repository.findById(id);
		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setFullname(user.getFullname());
                        _user.setEmail(user.getEmail());
                        _user.setPassword(user.getPassword());
                        _user.setPhone(user.getPhone());                       			
			return new ResponseEntity<>(repository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
