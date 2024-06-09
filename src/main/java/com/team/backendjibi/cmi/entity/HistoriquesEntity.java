package com.team.backendjibi.cmi.entity;

import com.team.backendjibi.backOffice.entities.ClientEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
@Table(name="historiquePaiement")
public class HistoriquesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String facturePaye;
    private double montant;
    private String date;
    @ManyToOne
    @JoinColumn(name="client_id")
    private ClientEntity client;
    @Column(name="client_id",insertable = false,updatable = false)
    private Long clientId;


}
