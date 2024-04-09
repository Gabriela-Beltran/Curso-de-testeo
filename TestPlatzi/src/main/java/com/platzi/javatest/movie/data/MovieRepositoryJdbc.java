package com.platzi.javatest.movie.data;

import com.platzi.javatest.movie.model.Genero;
import com.platzi.javatest.movie.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {


    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] orgs= {id};
        return jdbcTemplate.queryForObject("select * from movies where id = ?", orgs, movieMavaer);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("select * from movies",movieMavaer );
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies (name,minutes,genre) values (?,?,?)",
                movie.getName(),movie.getMinutes(),movie.getGenero().toString());
    }


    private static RowMapper<Movie> movieMavaer = new RowMapper<Movie>() {
        @Override
        public Movie mapRow(ResultSet rs, int rowNums) throws SQLException {
            return new Movie(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    Genero.valueOf(rs.getString("genre")));
        }
    };
}
