package com.team.backendjibi.CMI.services;

import com.team.backendjibi.CMI.dto.AccountDto;
import com.team.backendjibi.CMI.request.NewPlafondRequest;
import com.team.backendjibi.CMI.request.SoldeAccountRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {
    AccountDto addAccount(Long customerId , int Plafond);
    void deleteAccountById(Long Id);
    AccountDto getAccountById(Long id);
    List<AccountDto> getAllAccounts();

    void deposer(SoldeAccountRequest soldeAccountRequest);
    void retirer(SoldeAccountRequest soldeAccountRequest);

    void modifierPlafond(NewPlafondRequest newPlafondRequest);

}
