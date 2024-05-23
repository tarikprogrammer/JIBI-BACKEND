package com.team.backendjibi.cmi.entity;

import com.team.backendjibi.backOffice.entities.ClientEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AccountEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;
    private double solde;
    private String accountType;
    private int plafond;


}
