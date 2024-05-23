package com.team.backendjibi.CMI.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Creancier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomCreancier;
    private String imageUrl;
    private int codeCreancier;
    private String categorie;

    @OneToMany(mappedBy = "creancier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Creance> listCreances;

}
