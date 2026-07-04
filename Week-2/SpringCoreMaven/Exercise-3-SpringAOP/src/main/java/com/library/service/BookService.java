package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute() {
        System.out.println("Executing BookService business logic in AOP example...");
        if (bookRepository != null) {
            bookRepository.getBooks();
        }
    }
}
