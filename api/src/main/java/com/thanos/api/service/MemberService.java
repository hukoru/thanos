package com.thanos.api.service;

import com.thanos.api.domain.Account;
import com.thanos.api.domain.Member;
import com.thanos.api.domain.ProviderType;
import com.thanos.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MemberService {


    @Autowired
    private MemberRepository memberRepository;


/*
    public Member createBy(String nickname, String displaySetName, ProviderType providerType, String loginId, String password) {
        Account account = Account.of(displaySetName, providerType, loginId, password);
        return this.createBy(nickname, account);
    }
*/

/*
    protected Member createBy(String nickname, Account account) {
     /   Member member = Member.of(nickname, account);
        return this.saveBy(member);
    }
*/


    protected Member saveBy(Member member) {
        return memberRepository.save(member);
    }
}
