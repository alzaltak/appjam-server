package com.example.appjamserver.domain.user.service;

import com.example.appjamserver.domain.user.domain.User;
import com.example.appjamserver.domain.user.facade.UserFacade;
import com.example.appjamserver.domain.user.presentation.dto.request.CreateReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateReviewService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(Long userId, CreateReviewRequest request) {
        User targetUser = userFacade.findUserById(userId);
        targetUser.setBelieve(request.getStars());
    }

}
