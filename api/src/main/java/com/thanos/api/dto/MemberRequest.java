package com.thanos.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRequest {

    private String providerId;

    private String nickname;     //별명

    private String birthYear;    //생년 : YYYY

    private String birthMonth;   //생월 : MM

    private String birthDay;     //생일 : DD

    private String uuid;         //UUID


}
