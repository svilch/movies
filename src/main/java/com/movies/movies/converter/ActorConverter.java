package com.movies.movies.converter;

import com.movies.movies.dto.actor.ActorResponse;
import com.movies.movies.dto.actor.ActorSaveRequest;
import com.movies.movies.model.Actor;
import org.springframework.stereotype.Component;

@Component
public class ActorConverter {

    public Actor convert(ActorSaveRequest actorSaveRequest) {
        return Actor.builder()
                .name(actorSaveRequest.getName())
                .born(actorSaveRequest.getBorn())
                .build();
    }

    public ActorResponse convert(Actor actor) {
        return ActorResponse.builder()
                .id(actor.getId())
                .name(actor.getName())
                .born(actor.getBorn())
                .build();
    }
}
