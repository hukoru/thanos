package com.thanos.api.domain;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(exclude = {"member"})
@Entity
@Data
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Member member;


    private String loginId;         //로그인 아이디 (이메일 가입시에만 적용)

    private String password;        //패스워드

   /* @Setter
    private String providerType;    //인증 제공사 타입*/

    private String providerId;      //인증 제공사 타입

    //UUID

    //PUSH TOKEN
    //OS Version

    @Enumerated(EnumType.STRING)
    ProviderType providerType;


    private String displaySetName;


    public static Account of(String displaySetName, ProviderType providerType, String loginId, String password) {
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

    public static Account of(String displaySetName, String providerId, ProviderType providerType) {
        return builder()
            .displaySetName(displaySetName)
            .providerType(providerType)
            .providerId(providerId)
            .build();
    }

}
