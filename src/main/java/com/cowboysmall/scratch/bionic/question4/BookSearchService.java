package com.cowboysmall.scratch.bionic.question4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookSearchService {

    @Autowired
    public BookRepository repository;

    public boolean bookExists(String bookName) {

        return repository.getBooks().contains(bookName);
    }
}