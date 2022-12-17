package com.example.appjamserver.domain.home.service;

import com.example.appjamserver.domain.home.domain.repository.HomeRepository;
import com.example.appjamserver.domain.home.presentation.dto.response.HomeElement;
import com.example.appjamserver.domain.home.presentation.dto.response.QueryHomeListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryRegionHomeService {

    private final HomeRepository homeRepository;

    @Transactional(readOnly = true)
    public QueryHomeListResponse execute(String addRess) {
        return new QueryHomeListResponse(
                homeRepository.queryByAddress(addRess)
                        .stream()
                        .map(HomeElement::of)
                        .collect(Collectors.toList())
        );
    }

}
