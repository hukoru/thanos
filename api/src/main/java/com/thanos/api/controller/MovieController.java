package com.thanos.api.controller;

import com.thanos.api.common.constant.ResponseCode;
import com.thanos.api.domain.Home;
import com.thanos.api.domain.Movie;
import com.thanos.api.domain.MovieEvent;
import com.thanos.api.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
@RequiredArgsConstructor
public class MovieController {

  final MovieService service;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    public Flux<Movie> index() {
        return service.getAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    public Flux<Movie> add() {
        return service.addMovie();
    }
}
