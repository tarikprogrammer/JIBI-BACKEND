package com.team.backendjibi.cmi.controller;

import com.team.backendjibi.cmi.dto.TransactionDTO;
import com.team.backendjibi.cmi.services.TransactionService;
import com.team.backendjibi.request.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jibi")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/newTransaction")
    public String createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.createTransaction(transactionRequest);

    }



    @GetMapping("/allTransactions")
    public List<TransactionDTO> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transaction/{id}")
    public TransactionDTO getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }
}

