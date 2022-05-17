package com.movies.movies.service;

import com.movies.movies.model.Actor;
import com.movies.movies.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService{

    private final ActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor findByName(String name) {
        return (Actor) actorRepository.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
        actorRepository.deleteById(id);
    }
}
