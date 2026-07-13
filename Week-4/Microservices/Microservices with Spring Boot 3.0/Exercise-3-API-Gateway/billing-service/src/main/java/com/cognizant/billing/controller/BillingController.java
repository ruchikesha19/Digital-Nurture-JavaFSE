package com.cognizant.billing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @GetMapping
    public List<String> getBillingRecords() {
        return Arrays.asList("Invoice #1001: $120.00", "Invoice #1002: $45.50", "Invoice #1003: $300.00");
    }
}
