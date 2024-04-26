package com.backendSmaileasy.ParkinlogicBackend.dto;

import com.backendSmaileasy.ParkinlogicBackend.entity.PoliticasEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoliticasDTO {
    private Long id;
    private String label;
    private String html;
    private boolean requerida;

    public PoliticasDTO(Long id, String label, boolean requerida) {
        this.id = id;
        this.label = label;
        this.requerida = requerida;
    }

    public PoliticasDTO(Optional<PoliticasEntity> politicasEntity) {
    }
}
