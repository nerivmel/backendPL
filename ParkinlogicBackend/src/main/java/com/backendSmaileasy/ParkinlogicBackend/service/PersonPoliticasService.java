package com.backendSmaileasy.ParkinlogicBackend.service;

import com.backendSmaileasy.ParkinlogicBackend.dto.PersonPoliticasDTO;
import com.backendSmaileasy.ParkinlogicBackend.entity.PersonEntity;
import com.backendSmaileasy.ParkinlogicBackend.entity.PersonPoliticasEntity;
import com.backendSmaileasy.ParkinlogicBackend.entity.PoliticasEntity;
import com.backendSmaileasy.ParkinlogicBackend.repository.PersonPoliticasRepository;
import com.backendSmaileasy.ParkinlogicBackend.repository.PersonRepository;
import com.backendSmaileasy.ParkinlogicBackend.repository.PoliticasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PersonPoliticasService {

    private final PersonPoliticasRepository personPoliticasRepository;
    private final PersonRepository personRepository;
    private final PoliticasRepository politicasRepository;

    @Autowired
    public PersonPoliticasService(PersonPoliticasRepository personPoliticasRepository,
                                  PersonRepository personRepository,
                                  PoliticasRepository politicasRepository) {
        this.personPoliticasRepository = personPoliticasRepository;
        this.personRepository = personRepository;
        this.politicasRepository = politicasRepository;
    }

    public void registrarNuevoRegistro(PersonPoliticasDTO personPoliticasDTO) {
        Long personId = personPoliticasDTO.getPersonId();
        Long politicasId = personPoliticasDTO.getPoliticasId();

        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(personId);
        Optional<PoliticasEntity> optionalPoliticasEntity = politicasRepository.findById(politicasId);

        if (optionalPersonEntity.isPresent() && optionalPoliticasEntity.isPresent()) {
            PersonEntity personEntity = optionalPersonEntity.get();
            PoliticasEntity politicasEntity = optionalPoliticasEntity.get();

            PersonPoliticasEntity personPoliticasEntity = new PersonPoliticasEntity();
            personPoliticasEntity.setPerson(personEntity);
            personPoliticasEntity.setPoliticas(politicasEntity);
            personPoliticasEntity.setFechaDeRegistro(personPoliticasDTO.getFechaDeRegistro());

            personPoliticasRepository.save(personPoliticasEntity);
        } else {
            throw new RuntimeException("No se encontró una persona o política con el ID proporcionado.");
        }
    }
    public boolean hasUserAcceptedPolicyForFacility(Integer userId, Integer facilityId) {
        return personPoliticasRepository.existsByPersonIdAndPoliticasFacilityId(userId, facilityId);
    }

}
