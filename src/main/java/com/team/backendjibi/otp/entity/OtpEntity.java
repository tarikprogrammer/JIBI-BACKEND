package com.team.backendjibi.otp.entity;

import com.team.backendjibi.backOffice.entities.ClientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="otp")
public class OtpEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String otp;
    @OneToOne
    @JoinColumn(name="client_id")
    private ClientEntity client;
}
