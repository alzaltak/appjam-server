package com.example.appjamserver.domain.user.facade;

import com.example.appjamserver.domain.home.domain.Home;
import com.example.appjamserver.domain.user.domain.User;
import com.example.appjamserver.domain.user.domain.repository.UserLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikeFacade {

    private final UserLikeRepository userLikeRepository;

    public boolean checkLiked(User user, Home home) {
        return userLikeRepository.existsByUserAndHome(user, home);
    }

}