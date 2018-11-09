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


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class TimeEntity extends BaseEntity {

    @Getter
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date insertDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateDate;

    @Setter
    @Getter
    @Temporal(TemporalType.TIMESTAMP)
    protected Date expired;

}
