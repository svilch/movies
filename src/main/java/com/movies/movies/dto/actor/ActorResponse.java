package com.movies.movies.dto.actor;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActorResponse {

    private Long id;
    private String name;
    private String born;
}
