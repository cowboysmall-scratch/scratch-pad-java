package com.cowboysmall.scratch.bionic.question4;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {

    public List<String> getBooks() {

        List<String> books = new ArrayList<>();
        books.add("Book");
        books.add("Short book");
        books.add("Long book");
        return books;
    }
}
