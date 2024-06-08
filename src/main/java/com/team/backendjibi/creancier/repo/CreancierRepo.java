package com.team.backendjibi.creancier.repo;

import com.team.backendjibi.creancier.entities.CreanceEntity;
import com.team.backendjibi.creancier.entities.CreancierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreancierRepo extends JpaRepository<CreancierEntity,Long> {
    CreancierEntity findByCreanceEntities(CreanceEntity creanceEntity);
}
