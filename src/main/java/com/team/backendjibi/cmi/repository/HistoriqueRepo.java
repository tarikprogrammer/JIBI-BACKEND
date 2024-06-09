package com.team.backendjibi.cmi.repository;

import com.team.backendjibi.cmi.entity.HistoriquesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriqueRepo extends JpaRepository<HistoriquesEntity,Long> {
   List<HistoriquesEntity> findByClientId(Long id);
}
