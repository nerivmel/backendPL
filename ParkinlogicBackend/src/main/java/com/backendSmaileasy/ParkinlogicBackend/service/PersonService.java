package com.backendSmaileasy.ParkinlogicBackend.service;

import com.backendSmaileasy.ParkinlogicBackend.dto.PersonDTO;
import com.backendSmaileasy.ParkinlogicBackend.entity.PersonEntity;
import com.backendSmaileasy.ParkinlogicBackend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public PersonEntity findByDocAndDoctype(String doc, String doctype) {
        return personRepository.findByDocAndDoctype(doc, doctype);
    }

    public PersonEntity savePerson(PersonDTO personDTO) {
        String doc = personDTO.getDoc();
        String doctype = personDTO.getDoctype();

        // Verificar si ya existe una persona con el mismo correo electrónico
        PersonEntity existingPersonWithEmail = personRepository.findByEmail(personDTO.getEmail());
        if (existingPersonWithEmail != null) {
            throw new DataIntegrityViolationException("El correo electrónico ya está registrado en la base de datos.");
        }

        // Verificar si ya existe una persona con el mismo documento y tipo de documento
        PersonEntity existingPerson = personRepository.findByDocAndDoctype(doc, doctype);
        if (existingPerson != null) {
            throw new DataIntegrityViolationException("El documento ya está registrado en la base de datos.");
        }

        // Crear una nueva entidad de persona
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personDTO.getName());
        personEntity.setEmail(personDTO.getEmail());
        personEntity.setDoctype(personDTO.getDoctype());
        personEntity.setDoc(personDTO.getDoc());

        // Guardar la entidad de persona en el repositorio
        return personRepository.save(personEntity);
    }
}


