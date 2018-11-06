package com.thanos.api.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 서오석 on 2016. 5. 4..
 * DisplaySet: Menu를 구성하는 가장 큰 단위이며 모든 CP는 DisplaySet을 Key로 메뉴를 조회한다.
 */
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
                .setType(SetType.normal)
                .status(Status.on)
                .build();
    }

    public static DisplaySet of(String name, String description, SetType setType) {
        return builder()
                .name(name)
                .description(description)
                .setType(setType)
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
    @NotEmpty
    @Size(min = 1, max = 200)
    private String name;

    @Setter
    @Size(max = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    private SetType setType;

    @Enumerated(EnumType.STRING)
    private Status status;

    public void expire() {
        this.status = Status.expire;
        super.setExpired(new Date());
    }

    public void off() {
        this.status = Status.off;
    }

    public void on() {
        this.status = Status.on;
    }
}
