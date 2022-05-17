package com.movies.movies.converter;

import com.movies.movies.dto.movie.MovieResponse;
import com.movies.movies.dto.movie.MovieSaveRequest;
import com.movies.movies.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter {

    public Movie convert(MovieSaveRequest movieSaveRequest) {
        return Movie.builder()
                .title(movieSaveRequest.getTitle())
                .genre(movieSaveRequest.getGenre())
                .releaseYear(movieSaveRequest.getReleaseYear())
                .build();
    }

    public MovieResponse convert(Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .releaseYear(movie.getReleaseYear())
                .build();
    }
}

