package com.example.appjamserver.domain.user.service;

import com.example.appjamserver.domain.home.domain.Home;
import com.example.appjamserver.domain.home.facade.HomeFacade;
import com.example.appjamserver.domain.user.domain.User;
import com.example.appjamserver.domain.user.domain.UserLike;
import com.example.appjamserver.domain.user.domain.repository.UserLikeRepository;
import com.example.appjamserver.domain.user.facade.LikeFacade;
import com.example.appjamserver.domain.user.facade.UserFacade;
import com.example.appjamserver.domain.user.presentation.dto.response.LikeResponse;
import com.example.appjamserver.global.exception.LikeExist;
import com.example.appjamserver.global.exception.RemoveLikeExist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserLikeService {

    private final UserFacade userFacade;
    private final HomeFacade homeFacade;
    private final LikeFacade likeFacade;
    private final UserLikeRepository userLikeRepository;

    @Transactional
    public LikeResponse liked(Long homeId) {
        User user = userFacade.getCurrentUser();
        Home home = homeFacade.getHome(homeId);

        if (likeFacade.checkLiked(user, home)) {
            throw LikeExist.EXCEPTION;
        }

        home.addLikeCounts();
        return addLike(user, home);
    }

    @Transactional
    public LikeResponse deleteLiked(Long homeId) {
        User user = userFacade.getCurrentUser();
        Home home = homeFacade.getHome(homeId);

        if (!likeFacade.checkLiked(user, home)) {
            throw RemoveLikeExist.EXCEPTION;
        }

        home.minusLikeCounts();
        return removeLike(user, home);
    }

    private LikeResponse addLike(User user, Home home) {
        userLikeRepository.save(UserLike.builder()
                .user(user)
                .home(home)
                .build());

        return LikeResponse.builder()
                .likeCounts(home.getLikeCounts())
                .liked(likeFacade.checkLiked(user, home))
                .build();
    }

    private LikeResponse removeLike(User user, Home home) {

        userLikeRepository.deleteByUserAndHome(user, home);

        return LikeResponse.builder()
                .likeCounts(home.getLikeCounts())
                .liked(likeFacade.checkLiked(user, home))
                .build();
    }

}

