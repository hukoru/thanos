package com.thanos.api.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data
@Entity
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;


}
