package com.team.backendjibi.cmi.services;

import com.team.backendjibi.backOffice.entities.ClientEntity;
import com.team.backendjibi.backOffice.profiles.ClientProfile;
import com.team.backendjibi.cmi.accountDto.AccountDto;
import com.team.backendjibi.cmi.accountSolde.Solde;
import com.team.backendjibi.cmi.entity.Account;
import com.team.backendjibi.creancier.dto.CreancierDto;
import com.team.backendjibi.creancier.entities.CreancierEntity;
import com.team.backendjibi.creancier.repo.CreancierRepo;
import com.team.backendjibi.dto.ClientDto;
import com.team.backendjibi.repositoryJibi.repoEntities.RepoClient;
import com.team.backendjibi.repositoryJibi.repoProfiles.RepoProfileClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ServiceAccount {
    @Autowired
    private RepoClient repoClient;
    @Autowired
    private RepoProfileClient repoProfileClient;
    @Autowired
    private CreancierRepo creancierRepo;
    /* ----------------add account ---------------*/
    public AccountDto addAccount(String accountType){
        AccountDto accountDto = new AccountDto();
        switch (accountType){
            case "account de 200DH":
                accountDto.setSolde(Solde.DEUX_CENTS.getSolde());
                accountDto.setPlafond(Solde.DEUX_CENTS.getSolde());
                break;
            case "account de 5000DH":
                accountDto.setPlafond(Solde.CINQ_MILLE.getSolde());
                accountDto.setSolde(Solde.CINQ_MILLE.getSolde());
                break;
            case "account de 20000DH":
                accountDto.setSolde(Solde.VINGT_MILLE.getSolde());
                accountDto.setPlafond(Solde.VINGT_MILLE.getSolde());
                break;
            default:
                accountDto.setSolde(0);
                accountDto.setPlafond(0);

        }
        return accountDto;
    }

    /*------------consulation de solde------------- */

    public AccountDto consulterSolde(ClientDto clientDto){
        ClientProfile client = new ClientProfile();
        BeanUtils.copyProperties(clientDto,client);
        ClientProfile getClient = repoProfileClient.findByPhone(client.getPhone());
        ClientEntity clientEntity =repoClient.findById(getClient.getClientId()).get();
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(clientEntity,accountDto);
        BeanUtils.copyProperties(clientEntity.getAccount(),accountDto);
   return accountDto;

    }

    /*--------------------retirer un solde de compte du client -----------------------*/

    public double retirerSolde(double accountSolde, double frais, Account account){
        double currentSolde=account.getSolde();
        double result;
        if(currentSolde<accountSolde){
           result=0;

        }else{
            result=currentSolde-(accountSolde+accountSolde*(frais/100));

        }
        return result;

    }


}
