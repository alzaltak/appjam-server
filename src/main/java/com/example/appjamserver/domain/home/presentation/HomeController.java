package com.example.appjamserver.domain.home.presentation;

import com.example.appjamserver.domain.home.presentation.dto.request.CreateMyHomeRequest;
import com.example.appjamserver.domain.home.presentation.dto.response.QueryHomeDetailResponse;
import com.example.appjamserver.domain.home.presentation.dto.response.QueryHomeListResponse;
import com.example.appjamserver.domain.home.service.CreateMyHomeService;
import com.example.appjamserver.domain.home.service.QueryHomeDetailService;
import com.example.appjamserver.domain.home.service.QueryRegionHomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/home")
@RestController
public class HomeController {

    private final CreateMyHomeService createMyHomeService;
    private final QueryRegionHomeService queryRegionHomeService;
    private final QueryHomeDetailService queryHomeDetailService;

    @PostMapping
    public void createHome(@RequestBody @Valid CreateMyHomeRequest request) {
        createMyHomeService.execute(request);
    }

    @GetMapping
    public QueryHomeListResponse queryHomeListByRegion(@RequestParam("add_ress") String addRess) {
        return queryRegionHomeService.execute(addRess);
    }

    @GetMapping("/{home-id}")
    public QueryHomeDetailResponse queryHomeDetail(@PathVariable("home-id") Long homeId) {
        return queryHomeDetailService.execute(homeId);
    }

}
