package com.team.backendjibi.request;

import jakarta.persistence.Column;
import jakarta.transaction.Transactional;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Transactional
public class EntrepriseRequest {

    private String companySize;
    private String domain;

    private Long ClientId;
}
