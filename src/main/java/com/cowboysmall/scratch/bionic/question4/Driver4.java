package com.cowboysmall.scratch.bionic.question4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver4 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext();
        config.register(BookSearch.class);
        config.refresh();

        BookSearchService bookSearchService = config.getBean(BookSearchService.class);
        System.out.println(bookSearchService.bookExists("Book"));
        System.out.println(bookSearchService.bookExists("Short book"));
        System.out.println(bookSearchService.bookExists("Long book"));

        RecommendationService recommendationService = config.getBean(RecommendationService.class);
        System.out.println(recommendationService.recommendBook());

        System.out.println(bookSearchService.repository == recommendationService.repository);
    }
}
