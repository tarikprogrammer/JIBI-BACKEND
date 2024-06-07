package com.team.backendjibi.otp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OtpDtoResponse {
    private String phoneNumber;
    private String username;
    private String otp;
    private EnumStatus enumStatus;
}
