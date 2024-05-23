package com.team.backendjibi.CMI.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreanceRequest {

    private int codeCreance;
    private String nomCreance;
}
