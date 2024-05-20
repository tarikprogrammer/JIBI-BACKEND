package com.team.backendjibi.backOffice;

import com.team.backendjibi.CMI.entity.Account;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String piece_identite;
    private String numeroDePieceIdentite;
    private String addresse;
    private String email;
    private String phone;
    private String file;
    private String password;
    private String cover;

    @OneToOne(mappedBy = "Client", cascade = CascadeType.ALL)
    private Account account;

}
