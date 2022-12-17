package com.example.appjamserver.domain.home.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryHomeListResponse {

    private List<HomeElement> homeList;

}
