package com.team.backendjibi.backOffice.entities;

import com.team.backendjibi.backOffice.profiles.ClientProfile;
import com.team.backendjibi.CMI.entity.Account;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String piece_identite;
    private String numeroDePieceIdentite;
    private String addresse;
    private String file;
    @ToString.Exclude
    @OneToOne(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ClientProfile clientProfile;

}
