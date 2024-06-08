package com.team.backendjibi.cmi.repository;

import com.team.backendjibi.cmi.entity.CreanceEntity;
import com.team.backendjibi.cmi.entity.CreancierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreancierRepo extends JpaRepository<CreancierEntity,Long> {
    CreancierEntity findByCreanceEntities(CreanceEntity creanceEntity);
}
