package com.backendSmaileasy.ParkinlogicBackend.service;

import com.backendSmaileasy.ParkinlogicBackend.entity.ImageEntity;
import com.backendSmaileasy.ParkinlogicBackend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    @Transactional(readOnly = true)
    public ImageEntity findByFacility(String facility) {
        Optional<ImageEntity> optionalImageEntity = imageRepository.findByFacility(facility);
        if (optionalImageEntity.isPresent()) {
            ImageEntity imageEntity = optionalImageEntity.get();
            // Accede explícitamente a los datos LOB dentro del contexto de la transacción
            imageEntity.getDatosImagen();
            return imageEntity;
        } else {
            return null;
        }
    }
}
