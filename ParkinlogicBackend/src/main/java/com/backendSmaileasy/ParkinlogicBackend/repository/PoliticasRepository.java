package com.backendSmaileasy.ParkinlogicBackend.repository;

import com.backendSmaileasy.ParkinlogicBackend.entity.PersonEntity;
import com.backendSmaileasy.ParkinlogicBackend.entity.PoliticasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PoliticasRepository extends JpaRepository <PoliticasEntity,Long>  {
    List<PoliticasEntity> findByFacilityId(Long id);
}
