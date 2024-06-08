package com.team.backendjibi.creancier.repo;

import com.team.backendjibi.creancier.entities.CreanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreanceRepo extends JpaRepository<CreanceEntity,Long> {
    CreanceEntity findByRef(String ref);
    CreanceEntity findByCreance(String creance);
}
