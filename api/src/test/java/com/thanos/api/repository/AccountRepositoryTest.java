package com.thanos.api.repository;

import com.thanos.api.domain.Account;
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


    private String providerId;
    private Long accountId;

    @Before
    public void setUp() {

    }

    @Test
    public void saveAcountTest() {

//        Account account = Account.of("DEFAULT",Account.ProviderType.KAKAOTALK , "hukoru@naver.com", "1234");
  //      accountRepository.save(account);

        //providerId = account.getProviderId();

    //    System.out.println(accountId.toString());
      //  System.out.println(providerId);

        //Assert.assertEquals(new Long(1), accountId);
    //    Assert.assertEquals("hukoru@naver.com", providerId);


      //  System.out.println(codeList.size());
    }

}
