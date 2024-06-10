package com.team.backendjibi.cmi.services;

import com.team.backendjibi.cmi.dto.TransactionDTO;
import com.team.backendjibi.cmi.entity.Account;
import com.team.backendjibi.cmi.entity.Transaction;
import com.team.backendjibi.cmi.repository.RepoAccount;
import com.team.backendjibi.cmi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    public ResponseEntity<?> createTransaction(TransactionDTO transactionDTO) {
        Account senderAccount = accountRepository.findById(transactionDTO.getSenderAccountId())
                .orElse(null);
        if (senderAccount == null) {
            return new ResponseEntity<>("Sender account not found", HttpStatus.NOT_FOUND);
        }
        Account receiverAccount = accountRepository.findById(transactionDTO.getReceiverAccountId())
                .orElse(null);
        if (receiverAccount == null) {
            return new ResponseEntity<>("Receiver account not found", HttpStatus.NOT_FOUND);
        }
        BigDecimal senderBalance = BigDecimal.valueOf(senderAccount.getSolde());
        if (senderBalance.compareTo(transactionDTO.getAmount()) <0) {
            return new ResponseEntity<>("Insufficient funds in sender's account", HttpStatus.BAD_REQUEST);
        }

        // Deduct amount from sender's account
        senderAccount.setSolde(senderAccount.getSolde() - doubleValue(transactionDTO.getAmount()));
        accountRepository.save(senderAccount);
        // Add amount to receiver's account
        receiverAccount.setSolde(receiverAccount.getSolde() + doubleValue(transactionDTO.getAmount()));
        accountRepository.save(receiverAccount);

        // Create and save the transaction
        Transaction transaction = Transaction.builder()
                .type(transactionDTO.getType())
                .amount(transactionDTO.getAmount())
                .date(transactionDTO.getDate())
                .senderAccount(senderAccount)
                .receiverAccount(receiverAccount)
                .build();

        transaction = transactionRepository.save(transaction);
        transactionDTO.setId(transaction.getId());
        return new ResponseEntity<>(transactionDTO, HttpStatus.CREATED);
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
