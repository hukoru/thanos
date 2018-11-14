package com.thanos.api.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Builder
@Table(name="COMMON_CODE")
public class Code extends Auditable<Long> {

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


    public static Code of(Long codeId, String codeGroupId, String codeName, String languageCode, String useYn) {
        return builder()
            .codeId(codeId)
            .codeGroupId(codeGroupId)
            .codeName(codeName)
            .languageCode(languageCode)
            .useYn(useYn)
            .build();
    }

}
