package com.backendSmaileasy.ParkinlogicBackend.service;

import com.backendSmaileasy.ParkinlogicBackend.entity.ImageEntity;
import com.backendSmaileasy.ParkinlogicBackend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public ImageEntity guardarImagen(ImageEntity imageEntity) {
        // Lógica para guardar la imagen en la base de datos
        return imageRepository.save(imageEntity);
    }
}
