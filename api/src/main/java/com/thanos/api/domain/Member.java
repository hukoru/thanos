package com.thanos.api.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "member")
@NoArgsConstructor
@Getter
public class Member extends Auditable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nickname;     //별명
    @NotNull
    private String birthYear;    //생년 : YYYY
    @NotNull
    private String birthMonth;   //생월 : MM
    @NotNull
    private String birthDay;     //생일 : DD
    @NotNull
    private String uuid;         //UUID

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    public static Member of(String nickname,
                            String birthYear,
                            String birthMonth,
                            String birthDay,
                            String uuid,
                            Account account) {
        return builder()
            .nickname(nickname)
            .birthYear(birthYear)
            .birthMonth(birthMonth)
            .birthDay(birthDay)
            .account(account)
            .uuid(uuid)
            .build();
    }

    @Builder
    public Member(String nickname,
                  String birthYear,
                  String birthMonth,
                  String birthDay,
                  String uuid,
                  final Account account) {
        this.nickname = nickname;
        this.birthYear= birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.uuid = uuid;
        this.account = account;
    }

}
