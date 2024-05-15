package com.team.backendjibi.repositoryJibi;

import com.team.backendjibi.backOffice.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAgent extends JpaRepository<AgentEntity,Long> {
    AgentEntity findByPhone(String phone);

}
