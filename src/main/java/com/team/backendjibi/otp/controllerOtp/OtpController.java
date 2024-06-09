package com.team.backendjibi.otp.controllerOtp;

import com.team.backendjibi.otp.dto.OtpDtoRequest;
import com.team.backendjibi.otp.dto.OtpDtoResponse;
import com.team.backendjibi.otp.services.OtpServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jibi")
@CrossOrigin("*")
public class OtpController {
    @Autowired
    private OtpServices otpServices;


    @PostMapping("/otp/send")
    public OtpDtoResponse send(@RequestBody OtpDtoRequest otpDtoRequest) throws Exception {
        return otpServices.sendSms(otpDtoRequest);
    }

    @PostMapping("/otp/verify")
    public boolean verifyOtp(@RequestBody OtpDtoRequest otpDtoRequest){
        return otpServices.verifyOtp(otpDtoRequest);
    }
}
