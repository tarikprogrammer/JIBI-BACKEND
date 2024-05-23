package com.team.backendjibi.repositoryJibi.repoEntities;

import com.team.backendjibi.backOffice.entities.ClientEntity;
import com.team.backendjibi.dto.ClientDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoClient extends JpaRepository<ClientEntity,Long> {

}
