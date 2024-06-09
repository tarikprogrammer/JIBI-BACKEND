package com.team.backendjibi.otp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OtpDtoRequest {
    private String phone;
    private String fname;
    private String otp;
}
