package com.team.backendjibi.servicesJibi;

import com.team.backendjibi.backOffice.entities.ClientEntity;
import com.team.backendjibi.backOffice.profiles.AgentProfile;
import com.team.backendjibi.backOffice.profiles.ClientProfile;
import com.team.backendjibi.cmi.dto.AccountDto;
import com.team.backendjibi.cmi.entity.Account;
import com.team.backendjibi.cmi.repository.RepoAccount;
import com.team.backendjibi.cmi.services.ServiceAccount;
import com.team.backendjibi.dto.AgentDto;
import com.team.backendjibi.dto.ClientDto;
import com.team.backendjibi.repositoryJibi.repoEntities.RepoClient;
import com.team.backendjibi.repositoryJibi.repoProfiles.RepoProfileClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class ServiceClient {
    @Autowired
    private RepoClient repoClient;
    @Autowired
    private RepoProfileClient repoProfileClient;
    @Autowired
    private ServiceAccount serviceAccount;
    @Autowired
    private RepoAccount repoAccount;


    public boolean create(ClientDto clientDto){
        boolean status=false;
        Account account= new Account();
        ClientEntity clientEntity = new ClientEntity();
        BeanUtils.copyProperties(clientDto,clientEntity);
        ClientProfile clientProfile = new ClientProfile();
        BeanUtils.copyProperties(clientDto,clientProfile);
        clientProfile.setClient(clientEntity);
        clientEntity.setClientProfile(clientProfile);
        AccountDto accountDto= serviceAccount.addAccount(clientEntity.getAccountType());
        BeanUtils.copyProperties(accountDto,account);
        account.setClient(clientEntity);
        clientEntity.setAccount(account);
        ClientEntity newClient = repoClient.save(clientEntity);
        if(newClient!=null)
           status=true;
        return status;
    }
    public List<ClientDto>getAllClient(){
        List<ClientEntity>clients=new ArrayList<>();
        clients=repoClient.findAll();
        System.out.println(clients.get(0).getClientProfile());
        List<ClientDto> allclients= new ArrayList<>();
        for(ClientEntity c:clients){
            ClientDto clientDto = new ClientDto();
            BeanUtils.copyProperties(c,clientDto);
            BeanUtils.copyProperties(c.getClientProfile(),clientDto);
            allclients.add(clientDto);
        }
        return allclients;
    }
    public ClientDto getClientDto(ClientDto clientDto){
        ClientEntity getClient = new ClientEntity();
        ClientProfile clientProfile = new ClientProfile();
        BeanUtils.copyProperties(clientDto,clientProfile);
        ClientDto clientDto1 = new ClientDto();
        ClientProfile isExist=repoProfileClient.findByPhone(clientProfile.getPhone());
        if(isExist!=null){
           getClient =repoClient.findById(isExist.getClientId()).get();
           BeanUtils.copyProperties(isExist,clientDto1);
           BeanUtils.copyProperties(getClient,clientDto1);
        }
        return clientDto1;
    }

    public boolean updatePassword(ClientDto clientDto){
        ClientProfile client = new ClientProfile();
        BeanUtils.copyProperties(clientDto,client);
        boolean status=false;
        ClientProfile getClient =repoProfileClient.findByPhone(client.getPhone());
        if(getClient!=null){
            getClient.setPassword(client.getPassword());
            client=repoProfileClient.save(getClient);
            status=true;
        }
        return status;

    }
    public ClientDto updateCover(ClientDto clientDto){
        boolean status=false;
        ClientProfile client=new ClientProfile();
        ClientDto clientDto1 = new ClientDto();
        BeanUtils.copyProperties(clientDto,client);
        ClientProfile getClient=repoProfileClient.findByPhone(client.getPhone());
        ClientEntity findClient=repoClient.findById(getClient.getClientId()).get();
        if(getClient!=null){
            getClient.setCover(client.getCover());
            client=repoProfileClient.save(getClient);
            BeanUtils.copyProperties(findClient,clientDto1);
            BeanUtils.copyProperties(client,clientDto1);
        }
        return clientDto1;
    }
    /*--------------------verify un solde de compte du client -----------------------*/
    public boolean verify(AccountDto accountDto){
        ClientProfile clientProfile = repoProfileClient.findByPhone(accountDto.getPhone());

        return serviceAccount.verifySolde(accountDto.getSolde(),clientProfile.getClientId());


    }

   /* --------------- efectuer un paiement ------------------*/
    public boolean effectuerPaiement(ClientDto clientDto){
        ClientEntity clientEntity = new ClientEntity();
        boolean status=false;
        clientEntity=repoClient.findClient(clientDto.getPhone());
        double result;
        String []impayes=clientDto.getImpayes().split("%");
        System.out.println(impayes[0]);
        Account account =repoAccount.findById(clientEntity.getId()).get();
        System.out.println(clientEntity.getAccount());
        if(clientEntity!=null){
            result= serviceAccount.retirerSolde(Double.parseDouble(clientDto.getSolde()),Double.parseDouble(impayes[0]),clientEntity.getAccount());

            if(result!=0){
                clientEntity.getAccount().setSolde(result);
                ClientEntity clientEntity1=repoClient.save(clientEntity);
                status=true;
            }

        }
        return status;
    }
}
