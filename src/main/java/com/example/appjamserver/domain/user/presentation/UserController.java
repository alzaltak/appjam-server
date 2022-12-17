package com.example.appjamserver.domain.user.presentation;

import com.example.appjamserver.domain.user.presentation.dto.request.CreateReviewRequest;
import com.example.appjamserver.domain.user.presentation.dto.request.UserSignInRequest;
import com.example.appjamserver.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.appjamserver.domain.user.presentation.dto.response.QueryRegionUserListResponse;
import com.example.appjamserver.domain.user.presentation.dto.response.TokenResponse;
import com.example.appjamserver.domain.user.service.CreateReviewService;
import com.example.appjamserver.domain.user.service.QueryRegionUserService;
import com.example.appjamserver.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;
    private final QueryRegionUserService queryRegionUserService;
    private final CreateReviewService createReviewService;

    @PostMapping("/token")
    public TokenResponse signIn(@RequestBody @Valid UserSignInRequest request) {
        return userService.execute(request);
    }

    @PostMapping("/signup")
    public TokenResponse signUp(@RequestBody @Valid UserSignUpRequest request) {
        return userService.execute(request);
    }

    @GetMapping
    public QueryRegionUserListResponse queryUserListByRegion(@RequestParam("add_ress") String addRess) {
        return queryRegionUserService.execute(addRess);
    }

    @PostMapping("/{user-id}")
    public void createReview(@PathVariable("user-id") Long userId,
                             @RequestBody @Valid CreateReviewRequest request) {
        createReviewService.execute(userId, request);
    }

}
