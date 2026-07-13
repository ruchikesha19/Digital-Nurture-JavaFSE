package com.cognizant.inventory;

import com.cognizant.inventory.model.Inventory;
import com.cognizant.inventory.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            inventoryRepository.save(new Inventory(null, 1L, 100));
            inventoryRepository.save(new Inventory(null, 2L, 500));
        };
    }
}
