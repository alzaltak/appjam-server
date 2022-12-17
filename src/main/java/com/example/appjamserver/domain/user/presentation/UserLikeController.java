package com.example.appjamserver.domain.user.presentation;

import com.example.appjamserver.domain.user.presentation.dto.response.LikeResponse;
import com.example.appjamserver.domain.user.service.UserLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserLikeController {

    private final UserLikeService userLikeService;

    @PostMapping("/{home-id}")
    public LikeResponse liked(@PathVariable("home-id") Long homeId) {
        return userLikeService.liked(homeId);
    }

    @DeleteMapping("/{home-id}")
    public LikeResponse deleteLike(@PathVariable("home-id") Long homeId) {
        return userLikeService.deleteLiked(homeId);
    }

}
