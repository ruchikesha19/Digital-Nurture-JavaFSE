package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute() {
        System.out.println("Executing BookService business logic...");
        if (bookRepository != null) {
            bookRepository.getBooks();
        } else {
            System.out.println("BookRepository injection is missing!");
        }
    }
}
