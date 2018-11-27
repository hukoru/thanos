package com.thanos.api.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

@Entity
@Builder
public class Member extends  Auditable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;         //계정 일련번호 PK

    private String nickname;    //별명

    @OneToOne(mappedBy = "member",  cascade = CascadeType.ALL)
    private Account account;


    // @JoinColumn(name = "accountId" , referencedColumnName = "accountId", nullable = false)
    // @JoinColumn(name = "accountId" ))
    //   @JoinTable(name = "account", joinColumns = @JoinColumn(name = "accountId"),
    //      inverseJoinColumns = @JoinColumn(name = "memberId"))

    public static Member of(String nickname, Account account) {
        return builder()
            .nickname(nickname)
            .account(account)
            .build();
    }

    //회원심사여부
    //생년
    //월
    //일

    //위도
    //경도
    //키

    //성별
    //가입보상여부
    //직업코드
    //학력코드
    //종교코드
    //흡연코드
    //음주코드
    //탈퇴코드
    //탈퇴사유
    /*

    NICKNAME         VARCHAR(255)  NULL     COMMENT '닉네임', -- 닉네임
    BIRTH_YEAR       VARCHAR(20)   NULL     COMMENT '생년', -- 생년
    BIRTH_MONTH      VARCHAR(2)   NULL     COMMENT '생월', -- 생월
    BIRTH_DAY        VARCHAR(2)   NULL     COMMENT '생일', -- 생일
    SCORE            INTEGER       NULL     COMMENT '매력도', -- 매력도
    LATITUDE         FLOAT(10,6)   NULL     COMMENT '위도', -- 위도
    LONGITUDE        FLOAT(10,6)   NULL     COMMENT '경도', -- 경도
    HEIGHT           INTEGER       NULL     COMMENT '키', -- 키
    JOIN_REWARD_YN   VARCHAR(1)    NULL     COMMENT '가입보상여부', -- 가입보상여부
    GENDER           VARCHAR(20)   NULL     COMMENT '성별', -- 성별
    JOB VARCHAR(4000) NULL     COMMENT '직업', -- 직업
    GRADUATION VARCHAR(4000) NULL     COMMENT '학력', -- 학력
    RELIGION_CODE    VARCHAR(20)   NULL     COMMENT '종교코드', -- 종교코드
    SMOKING_CODE     VARCHAR(20)   NULL     COMMENT '흡연코드', -- 흡연코드
    DRINKING_CODE    VARCHAR(20)   NULL     COMMENT '음주코드', -- 음주코드
    LEAVE_CAUSE_CODE VARCHAR(20)   NULL     COMMENT '탈퇴코드', -- 탈퇴코드
    LEAVE_CAUSE_DESC VARCHAR(4000) NULL     COMMENT '탈퇴사유', -- 탈퇴사유
    INSERT_ID        INTEGER       NULL     COMMENT '저장회원일련번호', -- 저장회원일련번호
    INSERT_DATE      DATETIME      NULL     COMMENT '저장일시', -- 저장일시
    UPDATE_ID        INTEGER       NULL     COMMENT '수정회원일련번호', -- 수정회원일련번호
    UPDATE_DATE      DATETIME      NULL     COMMENT '수정일시', -- 수정일시
    DELETE_ID        INTEGER       NULL     COMMENT '삭제회원일련번호', -- 삭제회원일련번호
    DELETE_DATE      DATETIME      NULL     COMMENT '삭제일시' -- 삭제일시*/

}
