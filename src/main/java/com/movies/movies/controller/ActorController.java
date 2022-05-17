package com.movies.movies.controller;

import com.movies.movies.converter.ActorConverter;
import com.movies.movies.dto.actor.ActorResponse;
import com.movies.movies.dto.actor.ActorSaveRequest;
import com.movies.movies.model.Actor;
import com.movies.movies.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;
    private ActorConverter actorConverter;

    @GetMapping
    public ResponseEntity<Set<ActorResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                actorService.findAll().stream()
                        .map(actor -> actorConverter.convert(actor))
                        .collect(Collectors.toSet()));
    }

    @PostMapping
    public ResponseEntity<ActorResponse> save(@RequestBody ActorSaveRequest actorSaveRequest) {
        Actor actor = actorConverter.convert(actorSaveRequest);
        Actor savedActor = actorService.save(actor);
        ActorResponse actorResponse = actorConverter.convert(savedActor);
        return ResponseEntity.status(HttpStatus.CREATED).body(actorResponse);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<ActorResponse> findByName(@PathVariable String name) {
        Actor actorList = actorService.findByName(name);
        ActorResponse actorResponse = actorConverter.convert(actorList);
        return ResponseEntity.status(HttpStatus.FOUND).body(actorResponse);
    }

    @DeleteMapping(value = "/id/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        actorService.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }
}
