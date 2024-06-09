package com.team.backendjibi.otp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OtpDtoResponse {
    private String phone;
    private String fname;
    private String otp;
    private EnumStatus enumStatus;
}
