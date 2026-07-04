package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void getBooks() {
        System.out.println("BookRepository: Fetching books using Annotation-based scan...");
    }
}
