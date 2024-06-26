package com.team.backendjibi.backOffice.profiles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.team.backendjibi.backOffice.entities.ClientEntity;
import com.team.backendjibi.shared.GeneratePassword;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="profileClient")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ClientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profile_id;
    @Column(nullable = false)
    private String password;
    private String cover;
    private String email;
    private String phone;
    @PrePersist
    public void generatePassword(){
        if(this.password==null){
            this.password= GeneratePassword.genererPassword();
        }
    }
    @OneToOne
    @JoinColumn(name="client_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ClientEntity client;
    @Column(name="client_id",insertable = false,updatable = false)
    private Long clientId;

}
