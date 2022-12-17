package com.example.appjamserver.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LikeResponse {

    private Integer likeCounts;
    private boolean liked;

}
