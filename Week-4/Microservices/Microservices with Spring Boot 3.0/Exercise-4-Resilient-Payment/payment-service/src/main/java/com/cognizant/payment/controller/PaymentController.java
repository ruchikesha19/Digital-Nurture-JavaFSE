package com.cognizant.payment.controller;

import com.cognizant.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/pay")
    public String makePayment(@RequestParam double amount, @RequestParam(defaultValue = "false") boolean fail) {
        return paymentService.processPayment(amount, fail);
    }
}
