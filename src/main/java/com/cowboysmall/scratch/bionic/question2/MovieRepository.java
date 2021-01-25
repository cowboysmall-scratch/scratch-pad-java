package com.cowboysmall.scratch.bionic.question2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;


@Repository
public class MovieRepository {

    @Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void createTable() {

        template.execute("CREATE TABLE movies (id bigint auto_increment primary key, name VARCHAR(50), year int, rating int)");
    }

    public void createMovie(String name, int year, int rating) {

        template.update("insert into movies (name, year, rating) values (?, ?, ?)", name, year, rating);
    }

    public List<Movie> findMoviesByName(String likeName) {
        return template.query(
                "select name, year, rating from movies where name like ?",
                new Object[]{likeName},
                (rs, rn) -> new Movie(rs.getString("name"), rs.getInt("year"), rs.getInt("rating"))
        );
    }
}
