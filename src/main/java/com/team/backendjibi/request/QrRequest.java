package com.team.backendjibi.request;

import com.team.backendjibi.backOffice.entities.ClientEntity;
import com.team.backendjibi.backOffice.profiles.ClientProfile;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import lombok.*;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Transactional
public class QrRequest {
    ClientEntity client;
}
