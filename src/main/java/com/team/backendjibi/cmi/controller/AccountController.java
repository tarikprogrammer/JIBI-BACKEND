package com.team.backendjibi.cmi.controller;

import com.team.backendjibi.backOffice.entities.ClientEntity;
import com.team.backendjibi.cmi.accountDto.AccountDto;
import com.team.backendjibi.cmi.services.ServiceAccount;
import com.team.backendjibi.dto.ClientDto;
import com.team.backendjibi.servicesJibi.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/jibi/")
public class AccountController {
    @Autowired
    private ServiceAccount serviceAccount;
    @Autowired
    private ServiceClient serviceClient;

    @PostMapping("/account/consulter")
    public AccountDto consulter(@RequestBody ClientDto clientDto){
        return serviceAccount.consulterSolde(clientDto);
    }
    @PostMapping("/account/paiement")
    public boolean test(@RequestBody ClientDto clientDto){
        return this.serviceClient.effectuerPaiement(clientDto);
    }
}
