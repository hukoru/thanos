package com.thanos.api.domain;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Getter
@Entity
@Builder
@EqualsAndHashCode(of = "accountId", callSuper = false)
public class Account extends  Auditable<Long> {

    @Getter
    @Id
    @GeneratedValue
    private Long accountId;         //계정 일련번호 PK

    @Setter
    private String loginId;         //로그인 아이디 (이메일 가입시에만 적용)

    @Setter
    private String password;        //패스워드

   /* @Setter
    private String providerType;    //인증 제공사 타입*/

    @Setter
    private String providerId;      //인증 제공사 타입

    @Enumerated(EnumType.STRING)
    ProviderType providerType;


    private String displaySetName;


    public enum ProviderType {
          EMAIL       //이메일
        , KAKAOTALK   //카카오톡
        , FACEBOOK    //페이스북

    }

    @Tolerate
    private Account(){}

    //이메일 인증
    public static Account of(String displaySetName , ProviderType providerType, String loginId, String password) {
        return builder()
            .displaySetName(displaySetName)
            .providerType(providerType)
            .loginId(loginId)
            .password(password)
            .build();
    }

    //써드파티 인증
    public static Account of(String providerId, ProviderType providerType) {
        return builder()
            .providerType(providerType)
            .providerId(providerId)
            .build();
    }

    public static Account of(String displaySetName , Long accountId, String providerId, ProviderType providerType) {
        return builder()
            .displaySetName(displaySetName)
            .accountId(accountId)
            .providerType(providerType)
            .providerId(providerId)
            .build();
    }

    public void email() {
        this.providerType = ProviderType.EMAIL;
    }
    public void kakaotalk() {
        this.providerType = ProviderType.KAKAOTALK;
    }
    public void facebook() {
        this.providerType = ProviderType.FACEBOOK;
    }



}
