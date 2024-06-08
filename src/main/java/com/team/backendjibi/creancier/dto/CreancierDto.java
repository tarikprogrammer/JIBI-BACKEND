package com.team.backendjibi.creancier.dto;

import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreancierDto {
    private Long id;
    private String logoCreancier;
    private String logoName;
    private String ref;
    private double solde;
    private String impayes;
    private String creance;

}
