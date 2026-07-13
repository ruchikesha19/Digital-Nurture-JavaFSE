package com.cognizant.order;

import com.cognizant.order.model.Order;
import com.cognizant.order.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(OrderRepository orderRepository) {
        return args -> {
            orderRepository.save(new Order(null, 1L, "Laptop", 1200.00));
            orderRepository.save(new Order(null, 2L, "Smartphone", 800.00));
        };
    }
}
