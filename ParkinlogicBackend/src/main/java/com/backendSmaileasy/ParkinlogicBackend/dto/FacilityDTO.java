package com.backendSmaileasy.ParkinlogicBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class FacilityDTO {
    private Long id;
    private String nombre;

    public FacilityDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }}