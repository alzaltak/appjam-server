package com.example.appjamserver.domain.user.service;

import com.example.appjamserver.domain.user.domain.User;
import com.example.appjamserver.domain.user.facade.UserFacade;
import com.example.appjamserver.domain.user.presentation.dto.response.QueryInfoElement;
import com.example.appjamserver.domain.user.presentation.dto.response.QueryMyInfoDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMyInfoDetailService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryMyInfoDetailResponse execute() {
        User user = userFacade.getCurrentUser();

        return QueryMyInfoDetailResponse.builder()
                .userId(user.getId())
                .profileImageUrl(user.getProfileImageUrl())
                .location(user.getHome().getLocation())
                .believe(user.getBelieve())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .queryInfoElement(QueryInfoElement.builder()
                        .firstName("Jamal")
                        .lastName("Murray")
                        .believe(5)
                        .location("미국 텍사스주")
                        .build())
                .build();
    }

}
