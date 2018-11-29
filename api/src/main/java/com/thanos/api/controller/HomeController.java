package com.thanos.api.controller;

import com.thanos.api.common.constant.ResponseCode;
import com.thanos.api.domain.*;
import com.thanos.api.repository.*;
import com.thanos.api.result.ResultBody;
import com.thanos.api.service.AccountService;
import com.thanos.api.service.CodeService;
import com.thanos.api.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class HomeController {

    private static final String template = "Hello, %s!";

    @Autowired
    private CodeService codeService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    public Home index(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Home(1, ResponseCode.OK.getMessage());
    }

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
     public ResultBody healthCheck() {

      //  Account account = Account.of("DEFAULT",  "hukoru@naver.com", Account.ProviderType.KAKAOTALK);


        //memberService.createBy(account);
        return new ResultBody();

    }

    @RequestMapping(value = "/healthcheck2", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    public ResultBody healthcheck2() throws UnknownHostException {


        Account account = Account.of("DEFAULT", ProviderType.KAKAOTALK, "hukoru@naver.com", "1234");
        accountService.saveBy(account);

        Member member = Member.of("맥주왕", account);

       // Member member = Member.builder().nickname("맥주왕").account(account).build();
        memberRepository.save(member);

        return new ResultBody();

    }


}












































