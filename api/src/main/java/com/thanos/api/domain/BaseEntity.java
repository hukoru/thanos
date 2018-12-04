package com.thanos.api.domain;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseEntity {

    /**
     * Entity 이름
     *
     * @return Class Name
     */

    public String getEntityName() {
        return this.getClass().getSimpleName();
    }
}
