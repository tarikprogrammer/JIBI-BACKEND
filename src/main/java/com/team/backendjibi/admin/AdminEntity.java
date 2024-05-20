package com.team.backendjibi.admin;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="admin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    @Column(nullable = false)
    private String password;
    @PrePersist
    void changePass(){
        if(this.password == null){
            this.password="ATRTRETRE";
        }
    }

}
