package com.team.backendjibi.CMI.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SoldeAccountRequest {
    private String identifiant;
    private Float amount;
}
