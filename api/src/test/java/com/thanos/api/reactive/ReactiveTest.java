package com.thanos.api.reactive;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "development")
public class ReactiveTest {

    @Before
    public void setUp() {

    }


    @Test
    public void emptyFluxTest() throws InterruptedException {

        emptyFlux();
        fooBarFluxFromValues();
        counter();


    }

    //01. Return an empty Flux
    Flux<String> emptyFlux() {
        return Flux.empty();
    }

    //02. Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
    Flux<String> fooBarFluxFromValues() {
        return Flux.just("foo", "bar");
    }

    //03. Create a Flux from a List that contains 2 values "foo" and "bar"
    Flux<String> fooBarFluxFromList() {

        //Flux.fromIterable(List.of("1"));
        /*
        Flux.fromIterable(List.of("foo","bar")); //JAVA 9

        List<String> items = new ArrayList<>();
        items.add("foo");
        items.add("bar");
        return Flux.fromIterable(items);
        */
        return Flux.fromIterable(Arrays.asList("foo","bar"));
    }

    //04. Create a Flux that emits an IllegalStateException
    Flux<String> errorFlux() {
        return Flux.error(new IllegalStateException());
    }

    //05. Create a Flux that emits increasing values from 0 to 9 each 100ms
    Flux<Long> counter() throws InterruptedException {
        Flux.interval(Duration.ofMillis(100))
            .take(10);
        //  .subscribe(System.out::println);

        // Thread.sleep(5000);

        return null;
    }

    //06. Return an empty Mono
    Mono<String> emptyMono() {
        return Mono.empty();
    }


    //07. Return a Mono that never emits any signal
    Mono<String> monoWithNoSignal() {
        return Mono.never();
    }


    //08. Return a Mono that contains a "foo" value
    Mono<String> fooMono() {
        return Mono.just("foo");
    }


    //09. Create a Mono that emits an IllegalStateException
    Mono<String> errorMono() {
        return Mono.error(new IllegalStateException());
    }




}
