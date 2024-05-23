package com.team.backendjibi.servicesJibi;

import com.team.backendjibi.backOffice.entities.ClientEntity;
import com.team.backendjibi.backOffice.profiles.ClientProfile;
import com.team.backendjibi.dto.ClientDto;
import com.team.backendjibi.repositoryJibi.repoEntities.RepoClient;
import com.team.backendjibi.repositoryJibi.repoProfiles.RepoProfileClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceClient {
    @Autowired
    private RepoClient repoClient;
    @Autowired
    private RepoProfileClient repoProfileClient;

    public boolean create(ClientDto clientDto){
        boolean status=false;
        ClientEntity clientEntity = new ClientEntity();
        BeanUtils.copyProperties(clientDto,clientEntity);
        ClientProfile clientProfile = new ClientProfile();
        BeanUtils.copyProperties(clientDto,clientProfile);
        clientProfile.setClient(clientEntity);
        clientEntity.setClientProfile(clientProfile);
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
}
