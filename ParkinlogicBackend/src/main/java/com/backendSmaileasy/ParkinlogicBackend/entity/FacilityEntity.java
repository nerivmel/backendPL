package com.backendSmaileasy.ParkinlogicBackend.entity;
import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class FacilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String ubicacion;

}

