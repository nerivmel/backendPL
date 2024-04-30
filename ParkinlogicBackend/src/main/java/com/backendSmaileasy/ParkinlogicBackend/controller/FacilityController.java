package com.backendSmaileasy.ParkinlogicBackend.controller;

import com.backendSmaileasy.ParkinlogicBackend.dto.FacilityDTO;
import com.backendSmaileasy.ParkinlogicBackend.service.FacilityService;

import com.backendSmaileasy.ParkinlogicBackend.dto.PoliticasDTO;
import com.backendSmaileasy.ParkinlogicBackend.service.PoliticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    private final PoliticasService politicasService;

    public FacilityController(PoliticasService politicasService) {
        this.politicasService = politicasService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}/policies")
    public List<PoliticasDTO> getPoliciesByFacilityId(@PathVariable Long id) {
        return politicasService.getPoliciesByFacilityId(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/facilities/{nombre}")
    public ResponseEntity<FacilityDTO> findFacilityByName(@PathVariable String nombre) {
        FacilityDTO facilityDTO = facilityService.findFacilityByName(nombre);
        if (facilityDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(facilityDTO);
        }
    }
}
