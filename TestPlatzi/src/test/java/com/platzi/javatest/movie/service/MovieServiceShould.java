package com.platzi.javatest.movie.service;

import com.platzi.javatest.movie.data.MovieRepository;
import com.platzi.javatest.movie.model.Genero;
import com.platzi.javatest.movie.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {

    private  MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository= Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genero.ACTION),
                        new Movie(2, "Memento", 113, Genero.THRILLER),
                        new Movie(3, "There's Something About Marty", 119, Genero.COMEDY),
                        new Movie(4, "Super 8", 112, Genero.THRILLER),
                        new Movie(5, "Scream", 111, Genero.HORROR),
                        new Movie(6, "Home Alone", 103, Genero.COMEDY),
                        new Movie(7, "Matrix", 136, Genero.ACTION)
                )
        );
         movieService = new MovieService(movieRepository);
    }

    @Test
    public void peliculasPorGenero() {

        Collection<Movie> movies= movieService.findMovieByGener(Genero.COMEDY);
        List<Integer> movieIds = getIntegers(movies);
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(3,6)));
    }

    @Test
    public void peliculas_por_duracion() {
        Collection<Movie> movies= movieService.findMovieByLenght(119);
        assertThat(getIntegers(movies), CoreMatchers.is(Arrays.asList(2,3,4,5,6)));

    }

    private static List<Integer> getIntegers(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}