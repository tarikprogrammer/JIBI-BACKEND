package com.team.backendjibi.cmi.repository;

import com.team.backendjibi.cmi.entity.CreanceEntity;
import com.team.backendjibi.cmi.entity.CreancierEntity;
import com.team.backendjibi.cmi.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {

    Entreprise findEntrepriseByClientId(Long clientId);

}
