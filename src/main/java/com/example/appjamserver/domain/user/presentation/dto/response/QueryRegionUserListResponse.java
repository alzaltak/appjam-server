package com.example.appjamserver.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryRegionUserListResponse {

    private List<UserElement> userList;

}
