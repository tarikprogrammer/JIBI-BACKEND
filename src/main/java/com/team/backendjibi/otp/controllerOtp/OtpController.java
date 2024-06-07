package com.team.backendjibi.otp.controllerOtp;

import com.team.backendjibi.otp.dto.OtpDtoRequest;
import com.team.backendjibi.otp.dto.OtpDtoResponse;
import com.team.backendjibi.otp.services.OtpServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/JIBI")
@Slf4j
public class OtpController {
    @Autowired
    private OtpServices otpServices;
    @PostMapping("/send")
    public OtpDtoResponse send(@RequestBody OtpDtoRequest otpDtoRequest) throws Exception {
        return otpServices.sendSms(otpDtoRequest);
    }
    @PostMapping("/verify")
    public boolean verifyOtp(@RequestBody OtpDtoRequest otpDtoRequest){
        return otpServices.verifyOtp(otpDtoRequest);
    }
}
