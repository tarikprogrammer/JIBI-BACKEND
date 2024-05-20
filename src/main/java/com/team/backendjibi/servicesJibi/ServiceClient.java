package com.team.backendjibi.servicesJibi;

import com.team.backendjibi.backOffice.AgentEntity;
import com.team.backendjibi.backOffice.ClientEntity;
import com.team.backendjibi.dto.AgentDto;
import com.team.backendjibi.dto.ClientDto;
import com.team.backendjibi.repositoryJibi.RepoClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceClient {
    @Autowired
    private RepoClient repoClient;
    public boolean create(ClientDto clientDto){
        boolean status=false;
        ClientEntity clientEntity = new ClientEntity();
        BeanUtils.copyProperties(clientDto,clientEntity);
        ClientEntity newClient = repoClient.save(clientEntity);

        if(newClient!=null)
           status=true;
        return status;
    }
    public List<ClientDto>getAllClient(){
        List<ClientEntity>clients=new ArrayList<>();
        clients=repoClient.findAll();
        List<ClientDto> allclients= new ArrayList<>();
        ClientDto clientDto=new ClientDto();
        for(ClientEntity c:clients){
           BeanUtils.copyProperties(c,clientDto);
           allclients.add(clientDto);
        }
        return allclients;
    }
    public ClientDto getClient(ClientDto clientDto){
        ClientEntity getClient = new ClientEntity();
        BeanUtils.copyProperties(clientDto,getClient);
        ClientDto clientDto1 = new ClientDto();
        ClientEntity isExist=repoClient.findByPhone(getClient.getPhone());
        if(isExist!=null){
            BeanUtils.copyProperties(isExist,clientDto1);
        }
        return clientDto1;
    }
}
