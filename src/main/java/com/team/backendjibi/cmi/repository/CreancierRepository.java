package com.team.backendjibi.CMI.repository;

import com.team.backendjibi.CMI.entity.Creancier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreancierRepository extends JpaRepository<Creancier , Long> {
}
