package com.team.backendjibi.cmi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.team.backendjibi.backOffice.entities.ClientEntity;
import com.team.backendjibi.shared.GeneratedRef;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
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
    @PrePersist
    public void generateReference(){
        this.ref= GeneratedRef.generateRef();
    }

}
