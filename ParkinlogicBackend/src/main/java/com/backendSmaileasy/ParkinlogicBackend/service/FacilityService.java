package com.backendSmaileasy.ParkinlogicBackend.service;

import com.backendSmaileasy.ParkinlogicBackend.dto.FacilityDTO;
import com.backendSmaileasy.ParkinlogicBackend.entity.FacilityEntity;
import com.backendSmaileasy.ParkinlogicBackend.repository.FacilityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityService {
    @Autowired
    private FacilityRepository facilityRepository;

    public FacilityDTO findFacilityByName(String nombre) {
        FacilityEntity facilityEntity = facilityRepository.findByNombre(nombre);
        if (facilityEntity!= null) {
            FacilityDTO facilityDTO = new FacilityDTO();
            facilityDTO.setId(facilityEntity.getId());
            facilityDTO.setNombre(facilityEntity.getNombre());
            return facilityDTO;
        } else {
            return null;
        }
    }
}
