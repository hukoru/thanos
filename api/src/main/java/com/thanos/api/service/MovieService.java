package com.thanos.api.service;

import com.thanos.api.domain.Movie;
import com.thanos.api.domain.MovieEvent;
import com.thanos.api.repository.MovieReactiveRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.stream.Stream;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class MovieService {

    final MovieReactiveRepository repository;


  public Flux<Movie> addMovie() {
      Flux<Movie> flux = Flux.just(new Movie("Walter"),
          new Movie("Skyler"),
          new Movie("Saul"),
          new Movie("Jesse"));

      repository.insert(flux).subscribe();

      return repository.findAll();
  }

  public Flux<Movie> getAll() {
    return repository.findAll();
  }

  public Flux<Movie> getLike(final String searchCriteria) {
    return repository.findAllByTitleContainingIgnoreCase(searchCriteria);
  }

  public Mono<Movie> getFirstLike(final String searchCriteria) {
    return repository.findFirstByTitleContainingIgnoreCase(searchCriteria);
  }

  public Mono<Movie> getById(final String id) {
    return repository.findById(id);
  }

  public Flux<MovieEvent> streamEvents(final String id) {
    val movie = getById(id);
    return movie.flatMapMany(s -> {
      val interval = Flux.interval(Duration.ofSeconds(1));
      val stream = Stream.generate(() -> new MovieEvent(s, now()));
      val event = Flux.fromStream(stream);
      val tuple2Flux = Flux.zip(interval, event);
      return tuple2Flux.map(Tuple2::getT2);
    });
  }
}
