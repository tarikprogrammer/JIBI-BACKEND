package com.team.backendjibi;
import com.team.backendjibi.creancier.services.CreancierServices;
import com.team.backendjibi.otp.otpConfig.OtpConfig;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendJibiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendJibiApplication.class, args);


    }

}
