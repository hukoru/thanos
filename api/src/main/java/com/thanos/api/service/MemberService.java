package com.thanos.api.service;

import com.thanos.api.domain.Member;
import com.thanos.api.exceptions.GlobalErrorInfoException;
import com.thanos.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MemberService {


    @Autowired
    private MemberRepository memberRepository;

    public Member saveBy(Member member) throws GlobalErrorInfoException {

      //  System.out.println("@@@ " + findBy("AAAA-BBBB-CCCC-DDDD"));
        //uuid 블랙 체크



        //this.findBy(memberId).orElseThrow(() -> new GlobalErrorInfoException(ErrorInfoEnum.ERR0013))

//        Member memberByUuid = this.findBy(member.getUuid());

      //  memberRepository.findByUuid(memberByUuid.getUuid()).orElseThrow(() -> new GlobalErrorInfoException(ErrorInfoEnum.ERR0087));


/*
        if (displaySet.getStatus() == DisplaySet.Status.expire)
            throw new SmartM */

        //가입여부 체크
        //닉네임 공백 체크
        //닉네임 체크
        return memberRepository.save(member);
    }



    public Optional<Member> findBy(String uuid) {
        return memberRepository.findByUuid(uuid);
    }

}
