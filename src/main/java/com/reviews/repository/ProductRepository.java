/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.repository;

import com.reviews.models.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
/**
 *
 * @author afrodeb
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findById(int id);  
}
