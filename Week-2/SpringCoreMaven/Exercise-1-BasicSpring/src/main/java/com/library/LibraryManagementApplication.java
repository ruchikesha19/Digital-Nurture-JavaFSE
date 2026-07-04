package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve and use beans
        BookService bookService = context.getBean("bookService", BookService.class);
        BookRepository bookRepository = context.getBean("bookRepository", BookRepository.class);

        bookService.execute();
        bookRepository.getBooks();
    }
}
