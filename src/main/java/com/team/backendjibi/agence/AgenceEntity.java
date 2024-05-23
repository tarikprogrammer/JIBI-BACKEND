package com.team.backendjibi.agence;

import com.team.backendjibi.backOffice.entities.AgentEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AgenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agence_id;
    private String agenceName;
    @Column(nullable = false)
    private String numeroPattente;
    @OneToMany(mappedBy = "agence",cascade = CascadeType.ALL)
    private List<AgentEntity> agentEntityList;
    @PrePersist
    public void agencePattente(){
        this.numeroPattente="JIBI4563";
    }

}
