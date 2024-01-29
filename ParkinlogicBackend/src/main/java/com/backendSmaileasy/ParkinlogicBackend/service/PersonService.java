package com.backendSmaileasy.ParkinlogicBackend.service;

import com.backendSmaileasy.ParkinlogicBackend.entity.PersonEntity;
import com.backendSmaileasy.ParkinlogicBackend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
        @Autowired
        private PersonRepository personRepository;

        public PersonEntity findByDocAndDocType(String doc, String docType) {
            return personRepository.findByDocAndDocType(doc, docType);
        }
}
