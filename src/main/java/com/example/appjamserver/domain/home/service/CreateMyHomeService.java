package com.example.appjamserver.domain.home.service;

import com.example.appjamserver.domain.home.domain.Home;
import com.example.appjamserver.domain.home.domain.repository.HomeRepository;
import com.example.appjamserver.domain.home.presentation.dto.request.CreateMyHomeRequest;
import com.example.appjamserver.domain.user.domain.User;
import com.example.appjamserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateMyHomeService {

    private final HomeRepository homeRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateMyHomeRequest request) {
        User user = userFacade.getCurrentUser();

        homeRepository.save(Home.builder()
                .homeInfo(request.getHomeInfo())
                .location(request.getLocation())
                .address(request.getAddress())
                .homeCategory(request.getHomeCategory())
                .item(request.getItem())
                .culture(request.getCulture())
                .homeImageUrl(request.getHomeImageUrl())
                .content(request.getContent())
                .share(request.getShare())
                .maxPeopleSize(request.getMaxPeopleSize())
                .title(request.getTitle())
                .roomCounts(request.getRoomCounts())
                .homeSize(request.getHomeSize())
                .endAt(request.getEndAt())
                .likeCounts(0)
                .user(user)
                .build());
    }

}
