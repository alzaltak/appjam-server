package com.example.appjamserver.domain.user.presentation.dto.response;

import com.example.appjamserver.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserElement {

    private final String profileImageUrl;
    private final String lastName;
    private final String firstName;
    private final Integer believe;

    public static UserElement of(User user) {
        return UserElement.builder()
                .profileImageUrl(user.getProfileImageUrl())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .believe(user.getBelieve())
                .build();
    }

}
