package com.platzi.javatest.movie.data;

import com.platzi.javatest.movie.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate( Movie movie);
}
