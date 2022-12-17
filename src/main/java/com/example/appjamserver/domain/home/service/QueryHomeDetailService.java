package com.example.appjamserver.domain.home.service;

import com.example.appjamserver.domain.home.domain.Home;
import com.example.appjamserver.domain.home.facade.HomeFacade;
import com.example.appjamserver.domain.home.presentation.dto.response.QueryHomeDetailResponse;
import com.example.appjamserver.domain.user.presentation.dto.response.UserElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryHomeDetailService {

    private final HomeFacade homeFacade;

    @Transactional(readOnly = true)
    public QueryHomeDetailResponse execute(Long homeId) {
        Home home = homeFacade.getHome(homeId);

        return QueryHomeDetailResponse.builder()
                .homeImageUrl(home.getHomeImageUrl())
                .title(home.getTitle())
                .location(home.getLocation())
                .homeInfo(home.getHomeInfo())
                .homeSize(home.getHomeSize())
                .userElement(UserElement.builder()
                        .userId(home.getUserId())
                        .profileImageUrl(home.getProfileImage())
                        .lastName(home.getLastName())
                        .firstName(home.getFirstName())
                        .believe(home.getBelieve())
                        .build())
                .build();
    }

}
