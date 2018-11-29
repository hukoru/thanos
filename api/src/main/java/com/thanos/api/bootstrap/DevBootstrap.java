package com.thanos.api.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

   // private MemberRepository memberRepository;


    public DevBootstrap() {
     //   this.accountRepository = accountRepository;
     //   this.memberRepository = memberRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        System.out.println("###### start bootstrap");
/*
        Account account = Account.of("DEFAULT",Account.ProviderType.KAKAOTALK , "hukoru@naver.com", "1234");

        Member member = new Member();
        member.setAccount(account);


        memberRepository.save(member);

        System.out.println(account.getProviderId());*/


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
