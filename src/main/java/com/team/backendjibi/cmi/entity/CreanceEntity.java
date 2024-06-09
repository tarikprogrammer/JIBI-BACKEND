package com.team.backendjibi.cmi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.backendjibi.shared.GeneratedRef;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "creance", fetch = FetchType.LAZY)
    private List<Transaction> transactions;



    public CreanceEntity(Long id, String creance, String ref, CreancierEntity creancier) {
        this.id = id;
        this.creance = creance;
        this.ref = ref;
        this.creancier = creancier;
    }



}