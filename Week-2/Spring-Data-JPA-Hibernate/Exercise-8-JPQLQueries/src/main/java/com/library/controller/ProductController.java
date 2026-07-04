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

    // JPQL query endpoints
    @GetMapping("/jpql/search")
    public List<Product> getProductsByCategoryAndPrice(@RequestParam String category, @RequestParam double price) {
        return productRepository.findByCategoryAndMinPrice(category, price);
    }

    @GetMapping("/jpql/keyword")
    public List<Product> getProductsByKeyword(@RequestParam String keyword) {
        return productRepository.searchByNameKeyword(keyword);
    }
}
