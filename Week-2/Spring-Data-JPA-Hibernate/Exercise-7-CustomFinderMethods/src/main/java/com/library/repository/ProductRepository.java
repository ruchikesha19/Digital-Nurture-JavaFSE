package com.library.repository;

import com.library.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Custom derived query finder methods
    List<Product> findByCategory(String category);
    
    List<Product> findByNameContaining(String name);
    
    List<Product> findByPriceLessThan(double price);
}
