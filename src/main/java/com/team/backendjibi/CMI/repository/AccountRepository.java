package com.team.backendjibi.CMI.repository;

import com.team.backendjibi.CMI.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findAccountByClient_Phone(String phone);

}
