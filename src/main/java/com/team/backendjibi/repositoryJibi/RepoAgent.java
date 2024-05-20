package com.team.backendjibi.repositoryJibi;

import com.team.backendjibi.backOffice.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepoAgent extends JpaRepository<AgentEntity,Long> {
    AgentEntity findByPhone(String phone);

}
