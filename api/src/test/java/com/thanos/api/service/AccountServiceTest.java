package com.thanos.api.service;

import com.thanos.api.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "development")
public class AccountServiceTest {

    @MockBean
    private AccountService accountService;

    private String providerId;
    private Long accountId;

    @Before
    public void setUp() {

    }

    @Test
    public void findTest() {
        Optional<Account> findBy = accountService.findBy(1);

  //      Account account = Account.of("DEFAULT",  "hukoru@naver.com", Account.ProviderType.KAKAOTALK);

//        memberService.createBy(account);


    }

}
