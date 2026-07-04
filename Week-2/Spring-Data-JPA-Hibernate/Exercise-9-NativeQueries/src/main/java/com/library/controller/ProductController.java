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

    // Native query endpoints
    @GetMapping("/native/category")
    public List<Product> getProductsByCategoryNative(@RequestParam String category) {
        return productRepository.findByCategoryNative(category);
    }

    @GetMapping("/native/price-greater-than")
    public List<Product> getProductsByPriceGreaterThanNative(@RequestParam double price) {
        return productRepository.findByPriceGreaterThanNative(price);
    }
}
