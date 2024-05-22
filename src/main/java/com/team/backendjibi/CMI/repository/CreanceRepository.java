package com.team.backendjibi.CMI.repository;

import com.team.backendjibi.CMI.entity.Creance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreanceRepository extends JpaRepository<Creance,Long > {
    List<Creance> findByCreancierId(Long creancierId);
}
