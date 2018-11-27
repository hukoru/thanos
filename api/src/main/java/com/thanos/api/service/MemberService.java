package com.thanos.api.service;

import com.thanos.api.domain.Account;
import com.thanos.api.domain.Member;
import com.thanos.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Service
public class MemberService {


    @Autowired
    private MemberRepository memberRepository;


    @Transactional
    public Member createBy(Account account) {
        return memberRepository.save(Member.of("맥주왕", account));
    }


}
