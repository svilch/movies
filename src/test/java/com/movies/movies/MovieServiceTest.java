package com.movies.movies;

import com.movies.movies.model.Movie;
import com.movies.movies.repository.MovieRepository;
import com.movies.movies.service.MovieServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;
    private MovieServiceImpl movieService;

    @BeforeEach
    void setUp() {
        movieService = new MovieServiceImpl(movieRepository);
    }

    @Test
    void verifySaveThrowNullPointerException() {
        Movie movie = null;
        Assertions.assertThrows(NullPointerException.class,
                () -> movieService.save(movie));
    }

    @Test
    void verifyFindAll() {
        movieService.findAll();
        Mockito.verify(movieRepository, Mockito.times(1)).findAll();
    }

    @Test
    void verifySaveSuccess() {
        Movie movie = new Movie();
        movieService.save(movie);
        Mockito.verify(movieRepository, Mockito.times(1)).save(movie);
    }
}
