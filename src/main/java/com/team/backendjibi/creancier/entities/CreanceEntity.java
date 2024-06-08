package com.team.backendjibi.creancier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.backendjibi.shared.GeneratedRef;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Transactional
public class CreanceEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String creance;
    private String ref;
    @PrePersist
    public void generateReference(){
            this.ref= GeneratedRef.generateRef();
    }
    @ManyToOne()
    @JoinColumn(name="creancier_id")
    @JsonIgnore
    private CreancierEntity creancier;

}
