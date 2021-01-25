package com.cowboysmall.scratch.bionic.question4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookSearch {

    @Bean
    public BookRepository bookRepository() {

        return new BookRepository();
    }

    @Bean
    public BookSearchService bookSearchService() {

        return new BookSearchService();
    }

    @Bean
    public RecommendationService recommendationService() {

        return new RecommendationService();
    }
}
