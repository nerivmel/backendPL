package com.backendSmaileasy.ParkinlogicBackend.repository;

import com.backendSmaileasy.ParkinlogicBackend.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
        PersonEntity findByDocAndDocType(String doc, String doc_type);
    }
