
package com.platzi.javatest.movie.model;

import java.util.Objects;

public class Movie {
    private Integer id;
    private String name;
    private Integer minutes;
    private Genero genero;

    public Movie(String name, Integer minutes, Genero genero) {
        this(null,name,minutes,genero);
    }

    public Movie(Integer id, String name, Integer minutes, Genero genero) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(minutes, movie.minutes) && genero == movie.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genero);
    }
}
