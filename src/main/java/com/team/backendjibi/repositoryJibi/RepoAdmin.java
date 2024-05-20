package com.team.backendjibi.repositoryJibi;

import com.team.backendjibi.admin.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoAdmin extends JpaRepository<AdminEntity,Long> {
}
