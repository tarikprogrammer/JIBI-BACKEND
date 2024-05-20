package com.team.backendjibi.CMI.controllers;
import com.team.backendjibi.CMI.dto.AccountDto;
import com.team.backendjibi.CMI.request.SoldeAccountRequest;
import com.team.backendjibi.CMI.services.AccountService;
import com.team.backendjibi.CMI.services.servicesImpl.AccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService ;

    @PostMapping("/newAccount")
    public ResponseEntity<AccountDto> addAccount(@RequestBody Long clientId){
        AccountDto accountDto = accountService.addAccount(clientId);
        return new ResponseEntity<>(accountDto, HttpStatus.CREATED);
    }

    @PutMapping("/deposer")
    public ResponseEntity<Void> deposer(@RequestBody SoldeAccountRequest soldeAccountRequest) {
        accountService.deposer(soldeAccountRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping ("/retirer")
    public ResponseEntity<Void> retirer(@RequestBody SoldeAccountRequest soldeAccountRequest) {
        accountService.retirer(soldeAccountRequest);
        return  ResponseEntity.ok().build();
    }

}
