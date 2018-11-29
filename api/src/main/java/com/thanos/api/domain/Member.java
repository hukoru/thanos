package com.thanos.api.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "member")
@NoArgsConstructor
@Getter
public class Member extends Auditable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;    //별명

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;


    @Builder
    public Member(String nickname, final Account account) {
        this.nickname = nickname;
        this.account = account;
    }



}
