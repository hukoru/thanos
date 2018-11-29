package com.thanos.api.repository;

import com.thanos.api.domain.Account;
import com.thanos.api.domain.ProviderType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "development")
public class AccountRepositoryTest {


    private String loginId;
    private String provideId;

    @MockBean
    private AccountRepository accountRepository;

    @Before
    public void setUp() {

    }

    @Test
    public void saveAcountTest() {

        Account account = Account.builder()
            .displaySetName("DEFAULT")
            .providerType(ProviderType.KAKAOTALK)
            .loginId("hukoru@naver.com")
            .password("1234").build();

        accountRepository.save(account);

        loginId = account.getLoginId();

        Assert.assertEquals("hukoru@naver.com", loginId);
    }

    @Test
    public void saveAcountByEmailTest() {

        //이메일 가입
        Account account = Account.of("DEFAULT", ProviderType.EMAIL, "hukoru@naver.com", "1234");

        accountRepository.save(account);

        loginId = account.getLoginId();

        Assert.assertEquals("hukoru@naver.com", loginId);
    }

    @Test
    public void saveAcountByFacebookTest() {

        //이메일 가입
        Account account = Account.of("DEFAULT", ProviderType.FACEBOOK, "facebook---");

        accountRepository.save(account);

        provideId = account.getProviderId();

        Assert.assertEquals("facebook---", provideId);
    }
}
