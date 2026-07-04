package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String serviceName;

    // Constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Constructor Injection: BookRepository successfully wired.");
    }

    // Setter injection
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
        System.out.println("Setter Injection: serviceName successfully set.");
    }

    public void execute() {
        System.out.println("BookService [" + serviceName + "] executing operations...");
        bookRepository.getBooks();
    }
}
