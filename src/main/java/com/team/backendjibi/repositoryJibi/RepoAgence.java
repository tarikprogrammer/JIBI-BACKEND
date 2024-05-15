package com.team.backendjibi.repositoryJibi;

import com.team.backendjibi.agence.AgenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAgence extends JpaRepository<AgenceEntity,Long> {
    AgenceEntity findByAgenceName(String agenceName);
}
