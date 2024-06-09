package com.team.backendjibi.backOffice.entities;

import com.team.backendjibi.backOffice.profiles.ClientProfile;
import com.team.backendjibi.cmi.entity.Account;
import com.team.backendjibi.cmi.entity.HistoriquesEntity;
import com.team.backendjibi.otp.entity.OtpEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private String accountType;
    @ToString.Exclude
    @OneToOne(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ClientProfile clientProfile;
    @OneToOne(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Account account;
    @OneToOne(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private OtpEntity otpClient;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<HistoriquesEntity> historiques;

}
