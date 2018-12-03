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

    @Autowired
    private MemberService memberService;


    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Home index(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Home(1, ResponseCode.OK.getMessage());
    }

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    @ResponseBody
    public ResultBody healthCheck() throws GlobalErrorInfoException {

        Optional<Member> uuid = memberService.findBy("AAAA-BBBB-CCCC-DDDD");

        if (uuid.isPresent()) {
            throw new GlobalErrorInfoException(ErrorInfoEnum.ERR0087);
        }

        return new ResultBody();

    }

    @RequestMapping(value = "/healthcheck2", method = RequestMethod.GET)
    @ResponseBody
    public ResultBody healthcheck2() throws UnknownHostException, GlobalErrorInfoException {

        Account account = Account.of("DEFAULT", ProviderType.KAKAOTALK, "hukoru@naver.com", "1234");
        accountService.saveBy(account);

        Member member = Member.of("맥주왕", "2000", "12", "25" , "AAAA-BBBB-CCCC-DDDD",  account);
        memberService.saveBy(member);

        return new ResultBody();

    }

    @RequestMapping(value = "/member/{memberId}", method = RequestMethod.GET)
    @ResponseBody
    public ResultBody getUser (
        @PathVariable("memberId") Long memberId
    ) throws GlobalErrorInfoException {
        return new ResultBody(accountService.accountResponse(memberId));
    }

}












































