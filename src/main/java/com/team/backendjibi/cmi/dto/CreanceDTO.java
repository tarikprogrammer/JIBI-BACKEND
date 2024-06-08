package com.team.backendjibi.cmi.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreanceDTO {
    private Long id;
    private int codeCreance;
    private String nomCreance;

}