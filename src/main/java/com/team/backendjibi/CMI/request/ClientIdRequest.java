package com.team.backendjibi.CMI.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientIdRequest {
    private Long clientId;
    private int Plafond;

}
