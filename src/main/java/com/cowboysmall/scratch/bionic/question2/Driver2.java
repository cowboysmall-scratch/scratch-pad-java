package com.cowboysmall.scratch.bionic.question2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/*

Modify the createMovie and findMoviesByName methods of the class MovieRepository.

 - Using JdbcTemplate, createMovie method should insert a new row into the movies
   table with the specified data.
 - Using JdbcTemplate, findMoviesByName should return a list of all movies from
   the 'movies' table, in which the name of the movie contains the likeName string,
   using the LIKE operator. The returned list should contain Movie objects with
   name, year, and rating fields correctly set.
 */

public class Driver2 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext();
        config.register(Config.class);
        config.refresh();

        MovieRepository repository = config.getBean(MovieRepository.class);
        repository.createMovie("Some movie", 1974, 3);
        repository.createMovie("Some other movie", 1993, 2);

        for (Movie movie : repository.findMoviesByName("Some%"))
            System.out.println(movie.name + " - " + movie.year + " - " + movie.rating);
    }
}
