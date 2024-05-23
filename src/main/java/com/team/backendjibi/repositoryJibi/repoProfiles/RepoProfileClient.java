package com.team.backendjibi.repositoryJibi.repoProfiles;

import com.team.backendjibi.backOffice.entities.ClientEntity;
import com.team.backendjibi.backOffice.profiles.ClientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepoProfileClient extends JpaRepository<ClientProfile,Long> {
    ClientProfile findByPhone(String phone);
}
