package com.thanos.api.domain;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account extends Auditable<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "account")
    private Member member;

    @Setter
    private String loginId;         //로그인 아이디 (이메일 가입시에만 적용)

    @Setter
    private String password;        //패스워드

    @Setter
    private String providerId;      //인증 제공사 타입

    //UUID
    //PUSH TOKEN
    //OS Version

    @Enumerated(EnumType.STRING)
    @NotNull
    ProviderType providerType;

    @Setter
    private String displaySetName;

    //이메일 인증
    public static Account of(String displaySetName, ProviderType providerType, String loginId, String password) {
        return builder()
            .displaySetName(displaySetName)
            .providerType(providerType)
            .loginId(loginId)
            .password(password)
            .build();
    }

    public static Account of(String displaySetName, ProviderType providerType, String providerId) {
        return builder()
            .displaySetName(displaySetName)
            .providerType(providerType)
            .providerId(providerId)
            .build();
    }

    @Builder
    public Account(String displaySetName, ProviderType providerType, String loginId, String password, String providerId) {
        this.displaySetName = displaySetName;
        this.providerType = providerType;
        this.providerId= providerId;
        this.loginId = loginId;
        this.password = password;
    }

}
