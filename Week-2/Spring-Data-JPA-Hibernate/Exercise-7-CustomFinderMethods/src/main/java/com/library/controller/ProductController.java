package com.library.controller;

import com.library.model.Product;
import com.library.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Custom finder endpoints
    @GetMapping("/search/category")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return productRepository.findByCategory(category);
    }

    @GetMapping("/search/name")
    public List<Product> getProductsByName(@RequestParam String name) {
        return productRepository.findByNameContaining(name);
    }

    @GetMapping("/search/price-less-than")
    public List<Product> getProductsByPriceLessThan(@RequestParam double price) {
        return productRepository.findByPriceLessThan(price);
    }
}
