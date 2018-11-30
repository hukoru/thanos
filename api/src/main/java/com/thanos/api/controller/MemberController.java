package com.thanos.api.controller;

import com.thanos.api.common.constant.ErrorInfoEnum;
import com.thanos.api.common.constant.ResponseCode;
import com.thanos.api.domain.Account;
import com.thanos.api.domain.Home;
import com.thanos.api.domain.Member;
import com.thanos.api.domain.ProviderType;
import com.thanos.api.exceptions.GlobalErrorInfoException;
import com.thanos.api.repository.AccountRepository;
import com.thanos.api.repository.MemberRepository;
import com.thanos.api.result.ResultBody;
import com.thanos.api.service.AccountService;
import com.thanos.api.service.CodeService;
import com.thanos.api.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;


@Controller
public class MemberController {

    private static final String template = "Hello, %s!";
/*

    */
/**
     * B001. 회원 가입
     *
     * @param version
     * @param device
     * @param provider
     * @return
     * @throws Exception
     *//*

    @RequestMapping(value = "/{version}/{device}/{provider}/signup/member", method = RequestMethod.POST)
    @ResponseBody
    public ResultBody register(@PathVariable("version") String version,
                               @PathVariable("device") String device,
                               @PathVariable("provider") String provider,
                               Member paramMember
    ) throws IOException, GlobalErrorInfoException {


        paramMember.setBirthYear(paramMember.getBirthday().substring(0,4));
        paramMember.setBirthMonth(paramMember.getBirthday().substring(5,6));
        paramMember.setBirthday(paramMember.getBirthday().substring(7,8));

        //단말기(uuid) 블랙리스트 처리
        if (memberService.selectBlackUuidCount(paramMember) > 0) {
            throw new GlobalErrorInfoException(ErrorInfoEnum.ERR0087);
        }

        //닉네임 공백 체크
        if(StringUtil.isEmptyAndSpaceCheck(paramMember.getNickname())){
            throw new GlobalErrorInfoException(ErrorInfoEnum.ERR0084);
        }

        //가입여부 체크
        if (memberService.countMemberAccount(paramMember) > 0) {
            throw new GlobalErrorInfoException(ErrorInfoEnum.ERR0053);
        }

        //닉네임 체크
        if (memberService.countNickname(paramMember) > 0) {
            throw new GlobalErrorInfoException(ErrorInfoEnum.ERR0013);
        }

        //회원상태코드 : 정상
        paramMember.setStatusCode("STA001");
        paramMember.setJoinFlag("true");
        paramMember.setJoinRewardYn("N");
        paramMember.setDeviceOs(device);
        paramMember.setMemberJudgeYn("N");  // 신규심사여부 N
        paramMember.setProviderUserId(paramMember.getProviderId());
        paramMember.setScore(50);

        int memberId = 0;
        if (memberService.countMemberAccountByUuid(paramMember) > 0) {
            paramMember.setJoinRewardYn("Y");
        }

        try {
            memberId = memberService.insertMemberAccount(paramMember);
            if (memberId < 1) {
                throw new GlobalErrorInfoException(ErrorInfoEnum.ERR0002);
            }
        } catch (Exception ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) {
                throw new GlobalErrorInfoException(ErrorInfoEnum.ERR0013);
            } else {
                throw new GlobalErrorInfoException(ErrorInfoEnum.ERR0002);
            }
        }

        paramMember.setMemberId(memberId);

        MemberResponse resultMemberResponse = new MemberResponse(memberService.MemberInfo(paramMember).getAccessToken());

        return new ResultBody(resultMemberResponse);

    }

*/

}











































