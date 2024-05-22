package com.team.backendjibi.CMI.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Creance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int codeCreance;
    private String nomCreance;

    @ManyToOne
    @JoinColumn(name = "creancier_id")
    private Creancier creancier;

}
