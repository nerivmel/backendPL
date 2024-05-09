package com.backendSmaileasy.ParkinlogicBackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PersonPoliticasDTO {
    private Long politicasId;
    private Long personId;
    private Date fechaDeRegistro;
}
