package com.team.backendjibi.cmi.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class Transaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;      //Paiement de créance, Paiement d'un client,ou Réception de paiement(client)

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="sender_id" , nullable = false)
    private Account senderAccount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="receiver_id" , nullable = false)
    private Account receiverAccount;

    @ManyToOne
    @JoinColumn(name = "creance_id")
    private CreanceEntity creance;




}
