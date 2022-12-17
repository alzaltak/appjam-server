package com.example.appjamserver.domain.home.presentation.dto.response;

import com.example.appjamserver.domain.home.domain.Home;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HomeElement {

    private final String homeImageUrl;
    private final String location;
    private final String homeInfo;
    private final Integer homeSize;
    private final Integer maxPeopleSize;

    public static HomeElement of(Home home) {
        return HomeElement.builder()
                .homeImageUrl(home.getHomeImageUrl())
                .location(home.getLocation())
                .homeInfo(home.getHomeInfo())
                .homeSize(home.getHomeSize())
                .maxPeopleSize(home.getMaxPeopleSize())
                .build();
    }

}
