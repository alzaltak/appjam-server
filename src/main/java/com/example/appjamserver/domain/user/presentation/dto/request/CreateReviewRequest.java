package com.example.appjamserver.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CreateReviewRequest {

    @NotNull
    @Max(6)
    private Integer stars;

}
