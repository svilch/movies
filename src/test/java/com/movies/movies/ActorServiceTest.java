package com.movies.movies;

import com.movies.movies.model.Actor;
import com.movies.movies.repository.ActorRepository;
import com.movies.movies.service.ActorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ActorServiceTest {

    @Mock
    private ActorRepository actorRepository;
    private ActorServiceImpl actorService;

    @BeforeEach
    void setUp() {
        actorService = new ActorServiceImpl(actorRepository);
    }

    @Test
    void verifySaveThrowNullPointerException() {
        Actor actor = null;
        Assertions.assertThrows(NullPointerException.class,
                () -> actorService.save(actor));
    }

    @Test
    void verifyFindAll() {
        actorService.findAll();
        Mockito.verify(actorRepository, Mockito.times(1)).findAll();
    }

    @Test
    void verifySaveSuccess() {
        Actor actor = new Actor();
        actorService.save(actor);
        Mockito.verify(actorRepository, Mockito.times(1)).save(actor);
    }
}
