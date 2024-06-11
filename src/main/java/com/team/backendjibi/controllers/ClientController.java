package com.team.backendjibi.controllers;

import com.team.backendjibi.dto.ClientDto;
import com.team.backendjibi.servicesJibi.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jibi/")
@CrossOrigin("*")
public class ClientController {
    @Autowired
    private ServiceClient serviceClient;
    @PostMapping("webClient/login")
    public ClientDto login(@RequestBody ClientDto clientDto){
        System.out.println("test de getClient");
        return serviceClient.getClientDto(clientDto);
    }
    @PutMapping("webClient/update")
    public boolean update(@RequestBody  ClientDto clientDto){
        return serviceClient.updatePassword(clientDto);
    }
    @PutMapping("webClient/updateCover")
    public ClientDto update_cover(@RequestBody ClientDto clientDto){
        return serviceClient.updateCover(clientDto);
    }
}
