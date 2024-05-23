package com.team.backendjibi.CMI.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NewPlafondRequest {
    private String identifiant;
    private int plafond;
}
