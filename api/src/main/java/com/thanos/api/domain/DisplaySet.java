package com.thanos.api.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Getter
@Entity
@Builder
@EqualsAndHashCode(of = "id", callSuper = false)
public class DisplaySet extends TimeEntity {

    @Getter
    @Id
    @GeneratedValue
    private Long id; //pk

    @Tolerate
    public DisplaySet() {
    }

    public static DisplaySet of(String name, String description) {
        return builder()
                .name(name)
                .description(description)
                .build();
    }

    public static DisplaySet of(String name, String description, SetType setType) {
        return builder()
                .name(name)
                .description(description)
                .status(Status.on)
                .build();
    }

    public enum Status {
        on       //정상
        , off      //숨김
        , expire    //만료
        ;

    }

    public enum SetType {
        normal;

    }

    @Setter
    @Size(min = 1, max = 200)
    private String name;

    @Setter
    @Size(max = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    private SetType setType;

    @Enumerated(EnumType.STRING)
    private Status status;



    public void off() {
        this.status = Status.off;
    }

    public void on() {
        this.status = Status.on;
    }
}
