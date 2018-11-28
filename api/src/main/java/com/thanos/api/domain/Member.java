package com.thanos.api.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;    //별명

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;


    public static Member of(String nickname, Account account) {
        return builder()
            .nickname(nickname)
            .account(account)
            .build();
    }


}
