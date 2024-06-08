package com.team.backendjibi.cmi.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Data
public class TransactionDTO {
    private Long id;
    private String type;
    private BigDecimal amount;
    private LocalDateTime date;
    private Long senderAccountId;
    private Long receiverAccountId;
}
