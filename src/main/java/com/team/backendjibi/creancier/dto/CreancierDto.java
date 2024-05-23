package com.team.backendjibi.creancier.dto;

import com.team.backendjibi.creancier.entities.DescriptionEntity;
import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreancierDto {
    private Long id;
    private String logoCreancier;
    private String logoName;

}
