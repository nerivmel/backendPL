package com.backendSmaileasy.ParkinlogicBackend.repository;

import com.backendSmaileasy.ParkinlogicBackend.entity.FacilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository <FacilityEntity, Long> {
    FacilityEntity findByNombre(String nombre);
}
