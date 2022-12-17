package com.example.appjamserver.domain.home.facade;

import com.example.appjamserver.domain.home.domain.Home;
import com.example.appjamserver.domain.home.domain.repository.HomeRepository;
import com.example.appjamserver.global.exception.HomeNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HomeFacade {

    private final HomeRepository homeRepository;

    public Home getHome(Long homeId) {
        return homeRepository.findById(homeId)
                .orElseThrow(() -> HomeNotFound.EXCEPTION);
    }

}
