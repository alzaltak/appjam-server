package com.example.appjamserver.domain.home.presentation;

import com.example.appjamserver.domain.home.presentation.dto.request.CreateMyHomeRequest;
import com.example.appjamserver.domain.home.service.CreateMyHomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/home")
@RestController
public class HomeController {

    private final CreateMyHomeService createMyHomeService;

    @PostMapping
    public void createHome(@RequestBody @Valid CreateMyHomeRequest request) {
        createMyHomeService.execute(request);
    }

}
