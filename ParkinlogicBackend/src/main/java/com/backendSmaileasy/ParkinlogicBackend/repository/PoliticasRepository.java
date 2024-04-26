package com.backendSmaileasy.ParkinlogicBackend.repository;

import com.backendSmaileasy.ParkinlogicBackend.entity.PersonEntity;
import com.backendSmaileasy.ParkinlogicBackend.entity.PoliticasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliticasRepository extends JpaRepository <PoliticasEntity,Long>  {
}
