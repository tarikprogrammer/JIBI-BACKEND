package com.team.backendjibi.repositoryJibi;

import com.team.backendjibi.admin.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAdmin extends JpaRepository<AdminEntity,Long> {
}
