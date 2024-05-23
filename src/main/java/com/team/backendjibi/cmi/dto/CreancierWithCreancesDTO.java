package com.team.backendjibi.CMI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreancierWithCreancesDTO {
    private Long id;
    private String nomCreancier;
    private String imageUrl;
    private int codeCreancier;
    private String categorie;
    private List<CreanceDTO> listCreances;
}
