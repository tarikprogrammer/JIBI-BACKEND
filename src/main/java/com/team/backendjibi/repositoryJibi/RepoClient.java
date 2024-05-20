package com.team.backendjibi.repositoryJibi;

import com.team.backendjibi.backOffice.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoClient extends JpaRepository<ClientEntity,Long> {
}
