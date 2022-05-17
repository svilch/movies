package com.movies.movies.dto.movie;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieResponse {

    private Long id;
    private String title;
    private String genre;
    private String releaseYear;
}
