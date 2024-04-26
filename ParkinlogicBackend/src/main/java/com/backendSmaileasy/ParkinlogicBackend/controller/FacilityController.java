package com.backendSmaileasy.ParkinlogicBackend.controller;

import com.backendSmaileasy.ParkinlogicBackend.dto.PoliticasDTO;
import com.backendSmaileasy.ParkinlogicBackend.service.PoliticasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FacilityController {

    private final PoliticasService politicasService;

    public FacilityController(PoliticasService politicasService) {
        this.politicasService = politicasService;
    }

    @GetMapping("/{id}/policies")
    public List<PoliticasDTO> getPoliciesByFacilityId(@PathVariable Long id) {
        return politicasService.getPoliciesByFacilityId(id);
    }
}
