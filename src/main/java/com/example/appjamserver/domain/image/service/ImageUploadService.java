package com.example.appjamserver.domain.image.service;

import com.example.appjamserver.domain.image.presentation.dto.ImageUrlResponse;
import com.example.appjamserver.infrastructure.image.s3.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImageUploadService {

    private final S3Facade s3Facade;

    @Transactional(readOnly = true)
    public ImageUrlResponse execute(List<MultipartFile> images) {
        List<String> imageUrl = images.stream()
                .map(s3Facade::uploadImage)
                .collect(Collectors.toList());

        return new ImageUrlResponse(imageUrl);
    }

}

