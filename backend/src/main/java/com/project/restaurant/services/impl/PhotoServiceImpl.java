package com.project.restaurant.services.impl;

import com.project.restaurant.domain.entities.Photo;
import com.project.restaurant.services.PhotoService;
import com.project.restaurant.services.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final StorageService storageService;

    @Override
    public Photo uploadPhoto(MultipartFile file) {
        String photoId = UUID.randomUUID().toString();

        String url = storageService.store(file, photoId);

        Photo photo = new Photo();
        photo.setUrl(url);
        photo.setUploadDate(LocalDateTime.now());
        return photo;
    }

    @Override
    public Optional<Resource> getPhotoAsResources(String id) {
        return storageService.loadAsResource(id);
    }

}
