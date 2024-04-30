package com.backendSmaileasy.ParkinlogicBackend.repository;

import com.backendSmaileasy.ParkinlogicBackend.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository  extends JpaRepository<ImageEntity, Long> {
    Optional<ImageEntity> findByFacility(String facility);

}