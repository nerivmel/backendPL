package com.backendSmaileasy.ParkinlogicBackend.service;

import com.backendSmaileasy.ParkinlogicBackend.dto.PoliticasDTO;
import com.backendSmaileasy.ParkinlogicBackend.entity.PoliticasEntity;
import com.backendSmaileasy.ParkinlogicBackend.repository.PoliticasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliticasService {
    @Autowired
    private PoliticasRepository politicasRepository;

    public List<PoliticasEntity> getAllPoliticas() {
        return politicasRepository.findAll();
    }

    public Optional<PoliticasEntity> getPoliticasById(Long id) {
        return politicasRepository.findById(id);
    }

    public PoliticasEntity savePoliticas(PoliticasEntity politicasEntity) {
        return politicasRepository.save(politicasEntity);
    }

    public void deletePoliticas(Long id) {
        politicasRepository.deleteById(id);
    }
    public PoliticasService(PoliticasRepository politicasRepository) {
        this.politicasRepository = politicasRepository;
    }

    public List<PoliticasDTO> getPoliciesByFacilityId(Long id) {
        List<PoliticasEntity> politicas = politicasRepository.findByFacilityId(id);
        return politicas.stream().map(politica -> new PoliticasDTO(politica.getId(), politica.getLabel(), politica.isRequerida())).toList();
    }
}
