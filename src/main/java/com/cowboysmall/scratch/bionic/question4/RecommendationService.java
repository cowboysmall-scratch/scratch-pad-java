package com.cowboysmall.scratch.bionic.question4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RecommendationService {

    @Autowired
    public BookRepository repository;

    public String recommendBook() {

        return repository.getBooks().get(0);
    }
}
