package com.example.appjamserver.domain.user.service;

import com.example.appjamserver.domain.user.domain.User;
import com.example.appjamserver.domain.user.facade.UserFacade;
import com.example.appjamserver.domain.user.presentation.dto.request.CreateReviewRequest;
import com.example.appjamserver.global.exception.CannotReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateReviewService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(Long userId, CreateReviewRequest request) {
        User user = userFacade.getCurrentUser();
        User targetUser = userFacade.findUserById(userId);

        if (user.getId().equals(targetUser.getId())) {
            throw CannotReview.EXCEPTION;
        }
        targetUser.setBelieve(request.getStars());
        user.addReviewers();
    }

}
