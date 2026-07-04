package com.library.controller;

import com.library.model.Product;
import com.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/transactional")
    public String createProductTransactional(@RequestBody Product product, @RequestParam boolean shouldFail) {
        try {
            productService.saveProductWithTransaction(product, shouldFail);
            return "Product saved successfully within active transaction context.";
        } catch (Exception e) {
            return "Transaction rolled back due to error: " + e.getMessage();
        }
    }
}
