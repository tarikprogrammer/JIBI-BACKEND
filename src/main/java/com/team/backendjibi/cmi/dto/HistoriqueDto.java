package com.team.backendjibi.cmi.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class HistoriqueDto {
    private String fname;
    private String facturePaye;
    private double montant;
    private String date;
    private String phone;
}
