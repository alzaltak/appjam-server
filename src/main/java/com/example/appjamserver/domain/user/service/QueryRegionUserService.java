package com.example.appjamserver.domain.user.service;

import com.example.appjamserver.domain.user.domain.repository.UserRepository;
import com.example.appjamserver.domain.user.presentation.dto.response.QueryRegionUserListResponse;
import com.example.appjamserver.domain.user.presentation.dto.response.UserElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryRegionUserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public QueryRegionUserListResponse execute(String addRess) {

        return new QueryRegionUserListResponse(
                userRepository.queryByAddRess(addRess)
                        .stream()
                        .map(UserElement::of)
                        .collect(Collectors.toList())
        );
    }

}
