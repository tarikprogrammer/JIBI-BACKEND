package com.team.backendjibi.repositoryJibi.repoEntities;

import com.team.backendjibi.backOffice.entities.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepoAgent extends JpaRepository<AgentEntity,Long> {

}
