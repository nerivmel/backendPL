package com.backendSmaileasy.ParkinlogicBackend.repository;

import com.backendSmaileasy.ParkinlogicBackend.entity.PersonPoliticasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPoliticasRepository extends JpaRepository <PersonPoliticasEntity, Long> {
    boolean existsByPersonIdAndPoliticasFacilityId(Integer personId, Integer facilityId);
}
