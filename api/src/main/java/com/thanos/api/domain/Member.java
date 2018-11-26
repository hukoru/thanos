package com.thanos.api.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Getter
@Entity
@Builder
@EqualsAndHashCode(of = "memberId", callSuper = false)
public class Member extends  Auditable<Long> {

    @Getter
    @Id
    @GeneratedValue
    private Long memberId;         //계정 일련번호 PK

    private String name;

    @OneToOne
    @JoinColumn(name = "accountId")
    private Account account;


}
