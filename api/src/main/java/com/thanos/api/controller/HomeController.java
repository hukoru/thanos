package com.thanos.api.controller;

import com.thanos.api.common.constant.ErrorInfoEnum;
import com.thanos.api.common.constant.GlobalErrorInfoEnum;
import com.thanos.api.common.constant.ResponseCode;
import com.thanos.api.domain.*;
import com.thanos.api.exceptions.GlobalErrorInfoException;
import com.thanos.api.repository.*;
import com.thanos.api.result.ResultBody;
import com.thanos.api.service.AccountService;
import com.thanos.api.service.CodeService;
import com.thanos.api.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.Optional;


@Controller
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
    @ResponseBody
    public Home index(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Home(1, ResponseCode.OK.getMessage());
    }

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    @ResponseBody
    public ResultBody healthCheck() {

      //  Account account = Account.of("DEFAULT",  "hukoru@naver.com", Account.ProviderType.KAKAOTALK);


        //memberService.createBy(account);
        return new ResultBody();

    }

    @RequestMapping(value = "/healthcheck2", method = RequestMethod.GET)
    @ResponseBody
    public ResultBody healthcheck2() throws UnknownHostException {


        Account account = Account.of("DEFAULT", ProviderType.KAKAOTALK, "hukoru@naver.com", "1234");
        accountService.saveBy(account);

        Member member = Member.of("맥주왕", account);

       // Member member = Member.builder().nickname("맥주왕").account(account).build();
        memberRepository.save(member);

        return new ResultBody();

    }

    //@PathVariable("version") String version

    @RequestMapping(value = "/member/{memberId}", method = RequestMethod.GET)
    @ResponseBody
    public ResultBody getUser (
        @PathVariable("memberId") Long memberId
    ) throws GlobalErrorInfoException {

        //throw new GlobalErrorInfoException(ErrorInfoEnum.ERR0013);

        if(memberId > 1 ){
            throw new GlobalErrorInfoException(ErrorInfoEnum.ERR0013);
        }

        return new ResultBody();

        //accountService.findBy(memberId).orElseGet();

       // Optional<Account> account = accountService.findBy(memberId);
//GlobalErrorInfoEnum.PARAM_NOT_NULL

     //   Optional<Account> account = accountService.findBy(memberId);

        //System.out.println(ErrorInfoEnum.ERR0002.getMessage());

      //  account.orElseThrow(() -> new GlobalErrorInfoException(ErrorInfoEnum.ERR0013));

     //   return   ResultBody();

       //return  Optional.ofNullable(new AccountResponse.Response(accountService.findBy(memberId))).orElse(new ResultBody());

        //return new ResultBody(new );


       // throw new GlobalErrorInfoException(ErrorInfoEnum.ERR0013);

     //   System.out.println("#####" + account.toString());

      //  return new ResultBody();
    }


}












































