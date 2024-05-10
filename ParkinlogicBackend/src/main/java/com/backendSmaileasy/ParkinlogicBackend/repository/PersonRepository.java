package com.backendSmaileasy.ParkinlogicBackend.repository;

import com.backendSmaileasy.ParkinlogicBackend.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
        PersonEntity findByDocAndDoctype(String doc, String doctype);
        PersonEntity findByEmail(String email);
    }
