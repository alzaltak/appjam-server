package com.example.appjamserver.domain.user.facade;

import com.example.appjamserver.domain.user.domain.User;
import com.example.appjamserver.domain.user.domain.repository.UserRepository;
import com.example.appjamserver.global.exception.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFound.EXCEPTION);
    }

}
