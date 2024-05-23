package com.team.backendjibi.CMI.entity;


import com.team.backendjibi.backOffice.ClientEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double solde;

    private int plafond ; // can be either 200DH - 5 000DH - 20 000DH pour client particulier et ou 0DH/ sans plafond pou compte professionnel

    @OneToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @PrePersist
    public void initSolde(){
        this.solde=0;
    }


}
