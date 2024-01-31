package com.backendSmaileasy.ParkinlogicBackend.controller;

import com.backendSmaileasy.ParkinlogicBackend.dto.PersonDTO;
import com.backendSmaileasy.ParkinlogicBackend.entity.PersonEntity;
import com.backendSmaileasy.ParkinlogicBackend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class PersonController {
    private final PersonService personService;

    @Autowired

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @CrossOrigin(origins = "http://localhost:3000")

    @GetMapping("/persons")
    public ResponseEntity<PersonEntity> getPersonByDocAndDoc_type(
            @RequestParam String doc,
            @RequestParam String doctype
    ) {
        PersonEntity person = personService.findByDocAndDoctype(doc,doctype);
        if (person != null) {
            System.out.println("exito" + person);
            return new ResponseEntity<>(person, HttpStatus.OK);

        } else {

            String errorMessage = "No se encontraron registros con doc: " + doc + " y doctype: " + doctype;
            System.out.println("ERROR Numero de doc: "+doc+ ", Tipo de documento "+doctype);
            return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save")
    public ResponseEntity<PersonEntity> savePerson(@RequestBody PersonDTO personDTO) {
        PersonEntity savedPerson = personService.savePerson(personDTO);
        return ResponseEntity.ok(savedPerson);
    }
}

