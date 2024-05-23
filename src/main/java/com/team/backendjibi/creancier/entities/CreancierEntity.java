package com.team.backendjibi.creancier.entities;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Transactional
public class CreancierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creancier_id;
    private String logoCreancier;
    private String logoName;
    @ToString.Exclude
    @OneToMany(mappedBy = "creancier",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<DescriptionEntity>descriptionEntities;

}
