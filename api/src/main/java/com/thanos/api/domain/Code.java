package com.thanos.api.domain;

import lombok.Data;

import lombok.Builder;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@Table(name="COMMON_CODE")
public class Code extends TimeEntity {
    private static final long serialVersionUID = 1L;

    @Tolerate
    public Code() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeId;           //공통코드일련번호

    private String codeGroupId;     //코드그룹일련번호
    private String codeName;        //코드명
    private String languageCode;    //언어코드
    private String useYn;           //사용여부

    private Long insertId;      //저장회원일련번호
    private Long updateId;      //수정회원일련번호

    public static Code of(Long codeId, String codeGroupId, String codeName, String languageCode, String useYn, Long insertId, Long updateId) {
        return builder()
                .codeId(codeId)
                .codeGroupId(codeGroupId)
                .codeName(codeName)
                .languageCode(languageCode)
                .useYn(useYn)
                .insertId(insertId)
                .updateId(updateId)
                .build();
    }

}
