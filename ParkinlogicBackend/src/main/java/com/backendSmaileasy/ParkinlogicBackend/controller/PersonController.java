package com.backendSmaileasy.ParkinlogicBackend.controller;

import com.backendSmaileasy.ParkinlogicBackend.entity.PersonEntity;
import com.backendSmaileasy.ParkinlogicBackend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PersonController {
    private final PersonService personService;

    @Autowired

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @CrossOrigin(origins = "http://localhost:3000") // Permite solicitudes solo desde http://localhost:3000
    @GetMapping("/persons")
    public ResponseEntity<PersonEntity> getPersonByDocAndDocType(
            @RequestParam String doc,
            @RequestParam String docType
    ) {
        PersonEntity person = personService.findByDocAndDocType(doc, docType);
        if (person != null) {
            System.out.println("exito" + person);
            return new ResponseEntity<>(person, HttpStatus.OK);

        } else {

            String errorMessage = "No se encontraron registros con doc: " + doc + " y doctype: " + docType;
            System.out.println("ERROR Numero de doc: "+doc+ ", Tipo de documento "+docType);
            return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);

        }
    }
}
