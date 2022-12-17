package com.example.appjamserver.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryMyInfoDetailResponse {

    private final Long userId;
    private final String profileImageUrl;
    private final String lastName;
    private final String firstName;
    private final Integer believe;
    private final String location;
    private final QueryInfoElement queryInfoElement;
}
