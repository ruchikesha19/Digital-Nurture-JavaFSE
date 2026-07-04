package com.library.service;

import com.library.model.Product;
import com.library.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product saveProductWithTransaction(Product product, boolean shouldFail) {
        System.out.println("Executing service method inside transaction block...");
        
        Product savedProduct = productRepository.save(product);
        System.out.println("Product saved with ID: " + savedProduct.getId());

        if (shouldFail) {
            System.out.println("Simulating an error to trigger transactional rollback...");
            throw new RuntimeException("Simulated exception for rollback check");
        }

        return savedProduct;
    }
}
