package com.cognizant.payment.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackProcessPayment")
    public String processPayment(double amount, boolean simulateFailure) {
        if (simulateFailure) {
            logger.info("Simulating slow/failed call to third-party payment API for amount: {}", amount);
            throw new RuntimeException("Third-party payment gateway is slow or unresponsive");
        }
        return "Payment processed successfully for amount: $" + amount;
    }

    public String fallbackProcessPayment(double amount, boolean simulateFailure, Throwable throwable) {
        logger.warn("Resilience4j Fallback triggered due to error: {}", throwable.getMessage());
        return "Payment Status: PENDING (Fallback triggered. Reason: " + throwable.getMessage() + ")";
    }
}
