package com.movies.movies.controller;

import com.movies.movies.converter.MovieConverter;
import com.movies.movies.dto.movie.MovieResponse;
import com.movies.movies.dto.movie.MovieSaveRequest;
import com.movies.movies.model.Movie;
import com.movies.movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private MovieConverter movieConverter;

    @GetMapping
    public ResponseEntity<Set<MovieResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                movieService.findAll().stream()
                        .map(movie -> movieConverter.convert(movie))
                        .collect(Collectors.toSet()));
    }

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieSaveRequest movieSaveRequest) {
        Movie movie = movieConverter.convert(movieSaveRequest);
        Movie savedMovie = movieService.save(movie);
        MovieResponse movieResponse = movieConverter.convert(savedMovie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
    }

    @GetMapping(value = "/title/{title}")
    public ResponseEntity<MovieResponse> findByTitle(@PathVariable String title) {
        List<Movie> movieList = movieService.findByTitle(title);
        MovieResponse movieResponse = movieConverter.convert((Movie) movieList);
        return ResponseEntity.status(HttpStatus.FOUND).body(movieResponse);
    }

    @DeleteMapping(value = "/id/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }
}
