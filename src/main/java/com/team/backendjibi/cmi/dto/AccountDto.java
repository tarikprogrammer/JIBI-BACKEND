package com.team.backendjibi.cmi.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class AccountDto {
    private Long id;
    private int plafond;
    private double solde;
    private String accountType;
    private String ref;
    private String phone;
}
