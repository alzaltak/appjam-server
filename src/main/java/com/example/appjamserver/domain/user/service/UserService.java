package com.example.appjamserver.domain.user.service;

import com.example.appjamserver.domain.user.domain.User;
import com.example.appjamserver.domain.user.domain.repository.UserRepository;
import com.example.appjamserver.domain.user.presentation.dto.request.UserSignInRequest;
import com.example.appjamserver.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.appjamserver.domain.user.presentation.dto.response.TokenResponse;
import com.example.appjamserver.global.exception.PasswordMisMatch;
import com.example.appjamserver.global.exception.UserExist;
import com.example.appjamserver.global.exception.UserNotFound;
import com.example.appjamserver.global.security.jwt.JwtTokenProvider;
import com.example.appjamserver.infrastructure.image.DefaultImage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(UserSignInRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFound.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatch.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(request.getAccountId());

        return new TokenResponse(accessToken);
    }

    public TokenResponse execute(UserSignUpRequest request) {
        if (userRepository.findByAccountId(request.getAccountId()).isPresent()) {
            throw UserExist.EXCEPTION;
        }

        userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .myLang(request.getMyLang())
                .profileImageUrl(DefaultImage.USER_PROFILE_IMAGE)
                .believe(0)
                .build());

        String accessToken = jwtTokenProvider.generateAccessToken(request.getAccountId());

        return new TokenResponse(accessToken);
    }

}
