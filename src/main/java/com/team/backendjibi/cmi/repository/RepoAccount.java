package com.team.backendjibi.cmi.repository;

import com.team.backendjibi.cmi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAccount extends JpaRepository<Account,Long> {
    Account findByClientId(Long id);
    Account findAccountByClientId(Long id);
    Account findAccountByRef(String Ref);
}
