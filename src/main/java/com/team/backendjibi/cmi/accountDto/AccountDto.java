package com.team.backendjibi.cmi.accountDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AccountDto {
    private Long id;
    private int plafond;
    private double solde;
    private String accountType;
    private String ref;
}
