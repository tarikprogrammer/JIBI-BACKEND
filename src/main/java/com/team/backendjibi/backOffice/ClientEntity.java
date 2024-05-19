package com.team.backendjibi.backOffice;

import com.team.backendjibi.shared.GeneratePassword;
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
    @Column(nullable = false)
    private String password;
    private String cover;
    private String gender;
    @PrePersist
    public void randomPassword(){
        if(this.password == null){
            this.password=GeneratePassword.genererPassword();
            System.out.println(this.password+"for test tarik");
        }

    }


}
