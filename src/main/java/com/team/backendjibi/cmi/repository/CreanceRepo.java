package com.team.backendjibi.cmi.repository;

import com.team.backendjibi.cmi.entity.CreanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreanceRepo extends JpaRepository<CreanceEntity,Long> {
    CreanceEntity findByRef(String ref);
    CreanceEntity findByCreance(String creance);
}