package com.example.appjamserver.infrastructure.image.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.appjamserver.global.exception.ImageNotFound;
import com.example.appjamserver.global.exception.SaveImageFailed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class S3Facade {

    private final AmazonS3Client amazonS3Client;
    private final S3Properties s3Properties;

    public String uploadImage(MultipartFile image) {
        if (image.isEmpty() || image.getOriginalFilename() == null) {
            throw ImageNotFound.EXCEPTION;
        }

        String fileName = UUID.randomUUID() + image.getOriginalFilename();

        try {
            PutObjectRequest request = new PutObjectRequest(
                    s3Properties.getBucket(), fileName, image.getInputStream(), getObjectMetadata(image)
            ).withCannedAcl(CannedAccessControlList.PublicRead);

            amazonS3Client.putObject(request);

        } catch (Exception e) {
            throw SaveImageFailed.EXCEPTION;
        }

        return getFileUrl(fileName);
    }

    private ObjectMetadata getObjectMetadata(MultipartFile image) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(image.getSize());
        objectMetadata.setContentType(image.getContentType());

        return objectMetadata;
    }

    public String getFileUrl(String fileName) {
        return amazonS3Client.getUrl(s3Properties.getBucket(), fileName).toString();
    }

}
