package com.team.backendjibi.cmi.repository;

import com.team.backendjibi.cmi.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
