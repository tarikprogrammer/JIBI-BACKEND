package com.team.backendjibi.request;

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
public class TransactionRequest {
    private Long senderId;
    private String Rib;
    private BigDecimal Amount;
}
