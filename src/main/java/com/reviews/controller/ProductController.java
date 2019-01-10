/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.controller;

import com.reviews.models.Locations;
import com.reviews.models.Product;
import com.reviews.repository.ProductRepository;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author afrodeb
 */
@RestController
@RequestMapping("/api")
public class ProductController {
        @Autowired
	ProductRepository repository;
        @GetMapping("/product")    
    public List<Product> getAllproducts() {
        System.out.println("Get all products...");
		List<Product> products = new ArrayList<>();
		repository.findAll().forEach(products::add); 
		return products;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @PostMapping(value = "/product/create")
    public Product postProduct(@RequestBody Product product) {
        Product _product = repository.save(new Product(null, product.getName(),product.getDescription(),null));
	return _product;
    }
    
    @DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteLocation(@PathVariable("id") long id) {
		System.out.println("Delete location with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/product/delete")
	public ResponseEntity<String> deleteAllProducts() {
		System.out.println("Delete All products...");
		repository.deleteAll(); 
		return new ResponseEntity<>("All products have been deleted!", HttpStatus.OK);
	}
 
	@GetMapping(value = "product/id/{id}")
	public List<Product> findById(@PathVariable int id) {
		List<Product> products = repository.findById(id);
		return products;
	}
 
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
		System.out.println("Update product with ID = " + id + "..."); 
		Optional<Product> productData = repository.findById(id);
		if (productData.isPresent()) {
			Product _product = productData.get();
			_product.setName(product.getName());                                       			
			return new ResponseEntity<>(repository.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
