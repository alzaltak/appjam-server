package com.example.appjamserver.domain.home.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CreateMyHomeRequest {

    @NotBlank
    private String homeInfo;

    @NotBlank
    private String location;

    @NotBlank
    private String address;

    @NotNull
    private Integer roomCounts;

    @NotNull
    private Integer homeSize;

    @NotNull
    private Integer maxPeopleSize;

    @NotBlank
    private String homeImageUrl;

    @NotBlank
    private String homeCategory;

    @NotBlank
    private String culture;

    @NotBlank
    private String item;

    @NotBlank
    private String share; // 추천인

    @NotBlank
    private String title;

    @NotBlank
    private String content; // 내용글
}
