package com.platzi.javatest.movie.service;

import com.platzi.javatest.movie.data.MovieRepository;
import com.platzi.javatest.movie.model.Genero;
import com.platzi.javatest.movie.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMovieByGener (Genero genero){
        return movieRepository.findAll().stream().
                filter(movie -> movie.getGenero()== genero).collect(Collectors.toList());
    }


    public Collection<Movie> findMovieByLenght(int lenght) {
        return movieRepository.findAll().stream().filter(
                movie -> movie.getMinutes()<= lenght).collect(Collectors.toList());


    }
}