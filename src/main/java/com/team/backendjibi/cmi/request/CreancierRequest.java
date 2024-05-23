package com.team.backendjibi.CMI.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreancierRequest {

    private String nomCreancier;
    private String imageUrl;
    private int codeCreancier;
    private String categorie;
}
