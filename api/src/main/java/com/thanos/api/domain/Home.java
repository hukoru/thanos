package com.thanos.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Home {

    private int coupleCount;

    public static Home of( int coupleCount) {
        return builder()
            .coupleCount(coupleCount)
            .build();
    }

    @Builder
    public Home(int coupleCount) {
        this.coupleCount = coupleCount;
    }

}
