package com.team.backendjibi.backOffice.entities;

import com.team.backendjibi.agence.AgenceEntity;
import com.team.backendjibi.backOffice.profiles.AgentProfile;
import com.team.backendjibi.shared.GeneratePassword;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="agent")
@NoArgsConstructor
@AllArgsConstructor @Getter @Setter @Builder
@ToString
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
    private String numero_imm;
    private String numero_patente;
    private String file;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="agence_id")
    private AgenceEntity agence;
    @ToString.Exclude
    @OneToOne(mappedBy = "agent",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    private AgentProfile agentProfile;
}
