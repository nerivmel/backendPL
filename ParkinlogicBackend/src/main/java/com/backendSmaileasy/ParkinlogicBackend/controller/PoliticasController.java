package com.backendSmaileasy.ParkinlogicBackend.controller;


import com.backendSmaileasy.ParkinlogicBackend.entity.PoliticasEntity;
import com.backendSmaileasy.ParkinlogicBackend.service.PoliticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/politicas")
public class PoliticasController {
    @Autowired
    private PoliticasService politicasService;

    @GetMapping
    public ResponseEntity<List<PoliticasEntity>> getAllPoliticas() {
        List<PoliticasEntity> politicas = politicasService.getAllPoliticas();
        return ResponseEntity.ok(politicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoliticasEntity> getPoliticasById(@PathVariable("id") Long id) {
        Optional<PoliticasEntity> tuEntidad = politicasService.getPoliticasById(id);
        return tuEntidad.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PoliticasEntity> createPoliticas(@RequestBody PoliticasEntity politicasEntity) {
        PoliticasEntity createdTuEntidad = politicasService.savePoliticas(politicasEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTuEntidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PoliticasEntity> updatePoliticas(@PathVariable("id") Long id, @RequestBody PoliticasEntity politicasEntity) {
        if (!politicasService.getPoliticasById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        politicasEntity.setId(id);
        PoliticasEntity updatedPoliticas =politicasService.savePoliticas(politicasEntity);
        return ResponseEntity.ok(updatedPoliticas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoliticas(@PathVariable("id") Long id) {
        if (!politicasService.getPoliticasById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        politicasService.deletePoliticas(id);
        return ResponseEntity.noContent().build();
    }
}
