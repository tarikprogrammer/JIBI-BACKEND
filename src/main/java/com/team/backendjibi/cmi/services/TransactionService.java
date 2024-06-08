package com.team.backendjibi.cmi.services;

import com.team.backendjibi.cmi.dto.TransactionDTO;
import com.team.backendjibi.cmi.entity.Account;
import com.team.backendjibi.cmi.entity.Transaction;
import com.team.backendjibi.cmi.repository.RepoAccount;
import com.team.backendjibi.cmi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RepoAccount accountRepository;

    @Transactional
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Account senderAccount = accountRepository.findById(transactionDTO.getSenderAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Sender account not found"));
        Account receiverAccount = accountRepository.findById(transactionDTO.getReceiverAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Receiver account not found"));

        Transaction transaction = Transaction.builder()
                .type(transactionDTO.getType())
                .amount(transactionDTO.getAmount())
                .date(transactionDTO.getDate())
                .senderAccount(senderAccount)
                .receiverAccount(receiverAccount)
                .build();

        transaction = transactionRepository.save(transaction);
        transactionDTO.setId(transaction.getId());
        return transactionDTO;
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
