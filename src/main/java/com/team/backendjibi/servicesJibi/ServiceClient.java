package com.team.backendjibi.servicesJibi;

import com.team.backendjibi.backOffice.ClientEntity;
import com.team.backendjibi.dto.ClientDto;
import com.team.backendjibi.repositoryJibi.RepoClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceClient {
    @Autowired
    private RepoClient repoClient;

    public boolean create(ClientDto clientDto) {
        boolean status = false;
        ClientEntity clientEntity = new ClientEntity();
        BeanUtils.copyProperties(clientDto, clientEntity);
        ClientEntity newClient = repoClient.save(clientEntity);

        if (newClient != null)
            status = true;

        return status;
    }

    public List<ClientDto> getAllClient() {
        List<ClientEntity> clients = repoClient.findAll();
        List<ClientDto> allClients = new ArrayList<>();
        for (ClientEntity c : clients) {
            ClientDto clientDto = new ClientDto();
            BeanUtils.copyProperties(c, clientDto);
            allClients.add(clientDto);
        }
        return allClients;
    }
}
