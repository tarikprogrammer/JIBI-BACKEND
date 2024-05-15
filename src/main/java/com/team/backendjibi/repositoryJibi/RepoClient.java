package com.team.backendjibi.repositoryJibi;

import com.team.backendjibi.backOffice.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoClient extends JpaRepository<ClientEntity,Long> {
}
