package com.team.backendjibi.CMI.services.servicesImpl;

import com.team.backendjibi.CMI.dto.AccountDto;
import com.team.backendjibi.CMI.entity.Account;
import com.team.backendjibi.CMI.mapper.AccountMapper;
import com.team.backendjibi.CMI.repository.AccountRepository;
import com.team.backendjibi.CMI.request.NewPlafondRequest;
import com.team.backendjibi.CMI.request.SoldeAccountRequest;
import com.team.backendjibi.CMI.services.AccountService;
import com.team.backendjibi.backOffice.ClientEntity;
import com.team.backendjibi.repositoryJibi.RepoClient;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RepoClient repoClient;

    @Override
    @Transactional
    public AccountDto addAccount (Long ClientId , int Plafond) {
        ClientEntity client = repoClient.findById(ClientId).orElseThrow(() -> new RuntimeException("Client not found"));
        Account account = Account.builder().client(client).plafond(Plafond).build();
        accountRepository.save(account);
        return AccountMapper.mapAccountToAccountDto(account);
    }

    @Override
    public void  deleteAccountById( Long ClientId ) {
        accountRepository.deleteById(ClientId);
    }

    @Override
    public AccountDto getAccountById(Long ClientId) {
        return AccountMapper.mapAccountToAccountDto(
                accountRepository.findById(ClientId).orElseThrow(()->new RuntimeException("Account Not Found"))
        );
    }

    @Override
    public List<AccountDto> getAllAccounts(){
        return accountRepository.findAll().stream().map(AccountMapper::mapAccountToAccountDto).collect(Collectors.toList());
    }

    @Override
    public void deposer(SoldeAccountRequest soldeAccountRequest){
        Account account = accountRepository.findAccountByClient_Phone(soldeAccountRequest.getIdentifiant()).orElseThrow(()->new RuntimeException("Account Not Found"));
        if(account.getPlafond()== 0){
            account.setSolde(account.getSolde() + soldeAccountRequest.getAmount());
            accountRepository.save(account);
        } else if ((account.getPlafond() + soldeAccountRequest.getAmount())< account.getPlafond() ) {
            account.setSolde(account.getSolde() + soldeAccountRequest.getAmount());
            accountRepository.save(account);
        }else {
            throw new RuntimeException("Plafond du compte atteint");
        }
    }


    @Override
    public void retirer(SoldeAccountRequest soldeAccountRequest) {
        Account account = accountRepository.findAccountByClient_Phone(soldeAccountRequest.getIdentifiant()).orElseThrow(()->new RuntimeException("Account Not Found"));
        if(account.getSolde()< soldeAccountRequest.getAmount())
            throw new RuntimeException("Solde not sufficient");
        else account.setSolde(account.getSolde() - soldeAccountRequest.getAmount());
        accountRepository.save(account);
    }


    @Override
    public void modifierPlafond (NewPlafondRequest newPlafondRequest){
        Account account = accountRepository.findAccountByClient_Phone(newPlafondRequest.getIdentifiant()).orElseThrow(()->new RuntimeException("Account Not Found"));
        account.setSolde(account.getSolde() - newPlafondRequest.getPlafond());
        accountRepository.save(account);
    }



}
