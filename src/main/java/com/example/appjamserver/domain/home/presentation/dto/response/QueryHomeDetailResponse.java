package com.example.appjamserver.domain.home.presentation.dto.response;

import com.example.appjamserver.domain.user.presentation.dto.response.UserElement;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryHomeDetailResponse {

    private final String homeImageUrl;
    private final String title;
    private final String location;
    private final String homeInfo;
    private final Integer homeSize;
    private final UserElement userElement;

}
