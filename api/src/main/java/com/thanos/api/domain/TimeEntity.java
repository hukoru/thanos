package com.thanos.api.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by 서오석 on 2016. 5. 9..
 * 시간 정보만 모아둔 Entity
 * CreateDate, LastModifiedDate 사용 관련 참조 문서
 *
 * @link http://docs.spring.io/spring-data/jpa/docs/1.9.4.RELEASE/reference/html/#auditing
 * @link http://arahansa.github.io/docs_spring/jpa.html#auditing
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class TimeEntity extends BaseEntity {

    @Getter
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date created;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updated;

    @Setter
    @Getter
    @Temporal(TemporalType.TIMESTAMP)
    protected Date expired;

}
