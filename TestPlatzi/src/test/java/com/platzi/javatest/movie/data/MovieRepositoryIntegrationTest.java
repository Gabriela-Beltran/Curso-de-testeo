package com.platzi.javatest.movie.data;

import com.platzi.javatest.movie.model.Genero;
import com.platzi.javatest.movie.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepository;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws Exception {
         dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate=  new JdbcTemplate(dataSource);
         movieRepository= new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void cargar_todas_las_peliculas() throws SQLException {

       Collection<Movie> movies= movieRepository.findAll();
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1,"Dark Knight",152, Genero.ACTION),
                new Movie(2,"Memento",113,Genero.THRILLER),
                new Movie(3,"Matrix",136,Genero.ACTION)
        )));
    }

    @Test
    public void Cargar_pelicula_Por_ID() {
        Movie movie= movieRepository.findById(2);
        assertThat(movie,CoreMatchers.is(new Movie(2,"Memento",113,Genero.THRILLER)));

    }

    @Test
    public void Insertar_Pelicula() {
        Movie movie = new Movie(4,"Super 8",112,Genero.THRILLER);
        movieRepository.saveOrUpdate(movie);
        Movie movieExpected = movieRepository.findById(4);
        assertThat(movieExpected, CoreMatchers.is(movie));
    }

    @After
    public void tearDown() throws Exception {
        final Statement statement = dataSource.getConnection().createStatement();
        statement.execute("drop all objects delete files");
    }
}