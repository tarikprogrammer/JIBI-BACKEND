package com.team.backendjibi.repositoryJibi.repoProfiles;

import com.team.backendjibi.backOffice.profiles.AgentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoProfileAgent extends JpaRepository<AgentProfile,Long> {
    AgentProfile findByPhone(String phone);
}
