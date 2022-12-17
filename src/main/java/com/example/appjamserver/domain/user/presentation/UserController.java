package com.example.appjamserver.domain.user.presentation;

import com.example.appjamserver.domain.user.presentation.dto.request.UserSignInRequest;
import com.example.appjamserver.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.appjamserver.domain.user.presentation.dto.response.TokenResponse;
import com.example.appjamserver.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/token")
    public TokenResponse signIn(@RequestBody @Valid UserSignInRequest request) {
        return userService.execute(request);
    }

    @PostMapping("/signup")
    public TokenResponse signUp(@RequestBody @Valid UserSignUpRequest request) {
        return userService.execute(request);
    }
    
}
