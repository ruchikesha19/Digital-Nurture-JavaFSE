package com.cognizant.user;

import com.cognizant.user.model.User;
import com.cognizant.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User(null, "Alice Smith", "alice@example.com"));
            userRepository.save(new User(null, "Bob Johnson", "bob@example.com"));
        };
    }
}
