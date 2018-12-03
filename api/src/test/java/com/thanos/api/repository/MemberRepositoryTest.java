package com.thanos.api.repository;

import com.thanos.api.domain.Account;
import com.thanos.api.domain.Member;
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
public class MemberRepositoryTest {

    @MockBean
    private MemberRepository memberRepository;

    private String nickname;
    private Long memberId;

    @Before
    public void setUp() {
    }

    @Test
    public void saveMemberTest() {
        Account account = Account.of("DEFAULT", ProviderType.FACEBOOK, "facebook---");

        Member member = Member.of("맥주왕", "2000", "12", "25" , "AAAA-BBBB-CCCC-DDDD",  account);

        memberRepository.save(member);

        nickname = member.getNickname();
        Assert.assertEquals("맥주왕", nickname);
    }

}
