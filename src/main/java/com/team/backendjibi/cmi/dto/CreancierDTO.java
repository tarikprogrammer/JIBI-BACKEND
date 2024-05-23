package com.team.backendjibi.CMI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreancierDTO {
    private Long id;
    private String nomCreancier;
    private String imageUrl;
    private int codeCreancier;
    private String categorie;

}
