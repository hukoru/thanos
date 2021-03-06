package com.thanos.api.controller;

import com.thanos.api.common.constant.ErrorInfoEnum;
import com.thanos.api.domain.*;
import com.thanos.api.exceptions.GlobalErrorInfoException;
import com.thanos.api.exceptions.ThanosException;
import com.thanos.api.dto.AccountResponse;
import com.thanos.api.result.ApiResponse;
import com.thanos.api.service.AccountService;
import com.thanos.api.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ApiResponse index() {
        return new ApiResponse<>(Home.of(1500));
    }

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<Optional<Member>> healthCheck() throws GlobalErrorInfoException {

        Optional<Member> uuid = memberService.findBy("AAAA-BBBB-CCCC-DDDD");

        if (uuid.isPresent()) {
            throw new GlobalErrorInfoException(ErrorInfoEnum.ERR0087);
        }

        return new ApiResponse<>(uuid);
    }

    @RequestMapping(value = "/healthcheck2", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<Account> healthcheck2() throws UnknownHostException, GlobalErrorInfoException {

        Account account = Account.of("DEFAULT", ProviderType.KAKAOTALK, "hukoru@naver.com", "1234");
        accountService.saveBy(account);

        Member member = Member.of("맥주왕", "2000", "12", "25" , "AAAA-BBBB-CCCC-DDDD",  account);
        memberService.saveBy(member);

        return new ApiResponse<>(account);

    }

    @RequestMapping(value = "/member/{memberId}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getUser (
        @PathVariable("memberId") Long memberId
    ) throws GlobalErrorInfoException {

        AccountResponse.Response accountResponse;   //계정 응답

        try {
            accountResponse = accountService.accountResponse(memberId);

        } catch (ThanosException exception) {
            return ApiResponse.fail(exception.getCode(), exception.getMsg());
        }

        return new ApiResponse<>(accountResponse);

    }

}












































