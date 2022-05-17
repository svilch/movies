package com.movies.movies.service;

import com.movies.movies.exception.NotFoundRecordException;
import com.movies.movies.model.Movie;
import com.movies.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> findByTitle(String title) {
        try {
            return movieRepository.findByTitle(title);
        } catch (DataIntegrityViolationException exception) {
            throw new NotFoundRecordException(String.format("Movie %s, not found", title));
        }
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
