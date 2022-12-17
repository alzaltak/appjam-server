package com.example.appjamserver.domain.home.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HomeElement {

    private final String homeImageUrl;
    private final String location;
    private final String homeInfo;
    private final Integer homeSize;

}
