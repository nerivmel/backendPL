package com.backendSmaileasy.ParkinlogicBackend.controller;

import com.backendSmaileasy.ParkinlogicBackend.dto.PersonPoliticasDTO;
import com.backendSmaileasy.ParkinlogicBackend.service.PersonPoliticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonPoliticasController {

    private final PersonPoliticasService personPoliticasService;

    @Autowired
    public PersonPoliticasController(PersonPoliticasService personPoliticasService) {
        this.personPoliticasService = personPoliticasService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/personpoliticas")
    public ResponseEntity<String> registrarNuevoRegistro(@RequestBody PersonPoliticasDTO personPoliticasDTO) {
        personPoliticasService.registrarNuevoRegistro(personPoliticasDTO);
        return new ResponseEntity<>("Nuevo registro creado", HttpStatus.CREATED);
    }
}
