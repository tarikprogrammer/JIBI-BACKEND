package com.team.backendjibi.otp.repoOtp;

import com.team.backendjibi.otp.entity.OtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<OtpEntity, Long> {
    OtpEntity findByOtp(String otp);
}
