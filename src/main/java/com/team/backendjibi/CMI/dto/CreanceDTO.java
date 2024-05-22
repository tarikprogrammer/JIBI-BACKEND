package com.team.backendjibi.CMI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreanceDTO {

    private Long id;
    private int codeCreance;
    private String nomCreance;


}
