package com.movies.movies.service;

import com.movies.movies.model.Actor;

import java.util.List;

public interface ActorService {

    List<Actor> findAll();

    Actor save(Actor actor);

    Actor findByName(String name);

    void deleteById(Long id);
}
