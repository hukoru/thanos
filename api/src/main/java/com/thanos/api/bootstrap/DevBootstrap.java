package com.thanos.api.bootstrap;

import com.thanos.api.domain.*;
import com.thanos.api.repository.AccountRepository;
import com.thanos.api.repository.CategoryRepository;
import com.thanos.api.repository.RecipeRepository;
import com.thanos.api.repository.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private CategoryRepository categoryRepository;

    private UnitOfMeasureRepository unitOfMeasureRepository;


    public DevBootstrap(CategoryRepository categoryRepository,
                        UnitOfMeasureRepository unitOfMeasureRepository ) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){




        //recipeRepository.saveAll(getRecipes());

//        Account account = Account.of("default", Account.ProviderType.EMAIL, "hukoru@naver.com", "glasowk");

        //    Account.of("DEFAULT", "hukoru@naver.com", Account.ProviderType.KAKAOTALK);
  //      accountRepository.save(account);


        //  System.out.println(account.getProviderId());



/*        //Eric
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
        bookRepository.save(noEJB);*/
/*
        movieReactiveRepository.deleteAll()
            .thenMany(Flux.just("안녕하세요", "네 반갑습니다.", "안녕하세요~")
                .map(Movie::new)
                .flatMap(movieReactiveRepository::save))
            .subscribe(null, null, () ->
                movieReactiveRepository.findAll().subscribe(movie -> log.info("\n{}", movie)));*/
    }




}
