package com.team.backendjibi.backOffice;

import com.team.backendjibi.agence.AgenceEntity;
import com.team.backendjibi.shared.GeneratePassword;
import jakarta.persistence.*;
import lombok.*;

import java.io.File;
@Entity
@Table(name="agent")
@NoArgsConstructor
@AllArgsConstructor @Getter @Setter @Builder
public class AgentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String piece_identite;
    private String numeroDePieceIdentite;
    private String date_naissance;
    private String addresse;
    private String email;
    private String phone;
    private String numero_imm;
    private String numero_patente;
    private String file;
    private String username;
    private String imageUrl;
    @Column(nullable = false)
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="agence_id")
    private AgenceEntity agence;
    @PrePersist
    public void randomPassword(){
        if(this.password == null){
            this.password=GeneratePassword.genererPassword();
            System.out.println(this.password+"for test tarik");
        }

    }
}
