package com.team.backendjibi.cmi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.team.backendjibi.backOffice.entities.ClientEntity;
import com.team.backendjibi.shared.GeneratedRef;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double solde;

    private int plafond ;
    @Column(nullable = false)
    private String ref;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ClientEntity client;

///////////////////////////////////////////////////////////////////////////////////////////////
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "senderAccount")
    private List<Transaction> sentTransactions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receiverAccount")
    private List<Transaction> receivedTransactions;

    @PrePersist
    public void generateReference(){
        this.ref= GeneratedRef.generateRef();
    }

}
