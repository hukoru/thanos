package com.thanos.api.bootstrap;

import com.thanos.api.domain.Author;
import com.thanos.api.domain.Book;
import com.thanos.api.repository.AuthorRepository;
import com.thanos.api.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Slf4j
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
     //   this.movieReactiveRepository = movieReactiveRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Wrox" );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
/*
        movieReactiveRepository.deleteAll()
            .thenMany(Flux.just("안녕하세요", "네 반갑습니다.", "안녕하세요~")
                .map(Movie::new)
                .flatMap(movieReactiveRepository::save))
            .subscribe(null, null, () ->
                movieReactiveRepository.findAll().subscribe(movie -> log.info("\n{}", movie)));*/
    }
}
