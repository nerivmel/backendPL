package com.backendSmaileasy.ParkinlogicBackend.controller;

import com.backendSmaileasy.ParkinlogicBackend.entity.ImageEntity;
import com.backendSmaileasy.ParkinlogicBackend.repository.ImageRepository;
import com.backendSmaileasy.ParkinlogicBackend.service.ImageService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Optional;

@RestController
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
    @Autowired
    private ImageRepository imagenRepository;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/guardar")
    public ResponseEntity<String> guardarImagen(@RequestParam("nombre") String nombre,
                                                @RequestParam("facility") String facility,
                                                @RequestParam("datosImagen") MultipartFile datosImagen) {
        try {
            if (datosImagen.isEmpty()) {
                return ResponseEntity.badRequest().body("La imagen no puede estar vacía");
            }
            ImageEntity imagen = new ImageEntity();
            imagen.setNombre(nombre);
            imagen.setFacility(facility);
            imagen.setDatosImagen(datosImagen.getBytes()); // Convierte el MultipartFile a arreglo de bytes

            imagenRepository.save(imagen);

            return ResponseEntity.ok("Imagen guardada correctamente");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la imagen");
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/obtener-imagen/{id}")
    public ResponseEntity<byte[]> obtenerImagen(@PathVariable Long id) {
        Optional<ImageEntity> imagenOptional = imagenRepository.findById(id);
        if (imagenOptional.isPresent()) {
            ImageEntity imagen = imagenOptional.get();
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen.getDatosImagen());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getfacility/{facility}")
    public ResponseEntity<byte[]> getImageByFacility(@PathVariable String facility) {
        try {
            ImageEntity imageEntity = imageService.findByFacility(facility);
            if (imageEntity != null) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(imageEntity.getDatosImagen());
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found for facility: " + facility);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving image", e);
        }
    }



}