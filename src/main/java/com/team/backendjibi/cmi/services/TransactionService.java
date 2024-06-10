package com.team.backendjibi.cmi.services;

import com.team.backendjibi.cmi.dto.TransactionDTO;
import com.team.backendjibi.cmi.entity.Account;
import com.team.backendjibi.cmi.entity.Transaction;
import com.team.backendjibi.cmi.repository.RepoAccount;
import com.team.backendjibi.cmi.repository.TransactionRepository;
import com.team.backendjibi.request.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static org.aspectj.runtime.internal.Conversions.doubleValue;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RepoAccount accountRepository;

    @Transactional
    public boolean createTransaction(TransactionRequest transactionRequest) {
        Account senderAccount = accountRepository.findAccountByClientId(transactionRequest.getSenderId());
        if (senderAccount == null) {
            return false;
        }
            Account receiverAccount = accountRepository.findAccountByRef(transactionRequest.getRib());
        if (receiverAccount == null) {
            return false;

        }
        BigDecimal senderBalance = BigDecimal.valueOf(senderAccount.getSolde());
        if (senderBalance.compareTo(transactionRequest.getAmount()) <0) {
            return false;
        }

        if (BigDecimal.valueOf(receiverAccount.getPlafond())
                .compareTo(transactionRequest.getAmount()
                        .add(BigDecimal.valueOf(receiverAccount.getSolde())) ) <0 && (receiverAccount.getPlafond()!=0)) {
            return false;
        }

        // Deduct amount from sender's account
        senderAccount.setSolde(senderAccount.getSolde() - doubleValue(transactionRequest.getAmount()));
        accountRepository.save(senderAccount);
        // Add amount to receiver's account
        receiverAccount.setSolde(receiverAccount.getSolde() + doubleValue(transactionRequest.getAmount()));
        accountRepository.save(receiverAccount);

        //date formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(formatter);
        // Create and save the transaction payement
        Transaction transaction = Transaction.builder()
                .type("paiement")
                .amount(transactionRequest.getAmount())
                .date(formattedDate)
                .senderAccount(senderAccount)
                .receiverAccount(receiverAccount)
                .build();
        transactionRepository.save(transaction);
        // Create and save the transaction receipt
         transaction = Transaction.builder()
                .type("reception")
                .amount(transactionRequest.getAmount())
                .date(formattedDate)
                .senderAccount(receiverAccount)
                .receiverAccount(senderAccount)
                .build();
        transactionRepository.save(transaction);
        return true;
    }

    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public TransactionDTO getTransactionById(Long id) {
        return transactionRepository.findById(id).map(this::convertToDTO)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found"));
    }

    private TransactionDTO convertToDTO(Transaction transaction) {
        return TransactionDTO.builder()
                .id(transaction.getId())
                .type(transaction.getType())
                .amount(transaction.getAmount())
                .date(transaction.getDate())
                .senderAccountId(transaction.getSenderAccount().getId())
                .receiverAccountId(transaction.getReceiverAccount().getId())
                .build();
    }
}
