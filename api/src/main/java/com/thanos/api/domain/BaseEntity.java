package com.thanos.api.domain;

import javax.persistence.MappedSuperclass;

/**
 * Created by 서오석 on 2016. 5. 19..
 */
@MappedSuperclass
public class BaseEntity {

    /**
     * Entity 이름 (한글명이 필요한 경우 Override해서 한글명으로 변경하도록 하자)
     *
     * @return Class Name
     */

    public String getEntityName() {
        return this.getClass().getSimpleName();
    }
}
