package com.cognizant.order.controller;

import com.cognizant.order.client.UserClient;
import com.cognizant.order.dto.OrderResponse;
import com.cognizant.order.dto.UserDTO;
import com.cognizant.order.model.Order;
import com.cognizant.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserClient userClient;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    UserDTO user = null;
                    try {
                        user = userClient.getUserById(order.getUserId());
                    } catch (Exception e) {
                        user = new UserDTO(order.getUserId(), "Unknown User", "N/A");
                    }
                    OrderResponse response = new OrderResponse(
                            order.getId(),
                            order.getProduct(),
                            order.getAmount(),
                            user
                    );
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}
