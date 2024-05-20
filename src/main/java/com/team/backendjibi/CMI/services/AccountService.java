package com.team.backendjibi.CMI.services;

import com.team.backendjibi.CMI.dto.AccountDto;
import com.team.backendjibi.CMI.request.SoldeAccountRequest;

import java.util.List;

public interface AccountService {
    AccountDto addAccount(Long customerId);
    void deleteAccountById(Long Id);
    AccountDto getAccountById(Long id);
    List<AccountDto> getAllAccounts();

    void deposer(SoldeAccountRequest soldeAccountRequest);
    void retirer(SoldeAccountRequest soldeAccountRequest);

}
