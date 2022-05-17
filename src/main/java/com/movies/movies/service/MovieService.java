package com.movies.movies.service;

import com.movies.movies.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    Movie save(Movie movie);

    List<Movie> findByTitle(String title);

    void deleteById(Long id);
}
