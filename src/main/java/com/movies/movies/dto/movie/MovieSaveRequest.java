package com.movies.movies.dto.movie;

import lombok.Data;

@Data
public class MovieSaveRequest {

    private String title;
    private String genre;
    private String releaseYear;
}
