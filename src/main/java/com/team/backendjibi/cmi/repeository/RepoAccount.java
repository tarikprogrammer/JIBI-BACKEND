package com.team.backendjibi.cmi.repeository;

import com.team.backendjibi.cmi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAccount extends JpaRepository<Account,Long> {
}
