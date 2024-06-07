package com.team.backendjibi.otp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OtpDtoRequest {
    private String phoneNumber;
    private String username;
    private String otp;
}
