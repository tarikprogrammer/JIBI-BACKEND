package com.team.backendjibi;

import com.team.backendjibi.agence.AgenceEntity;
import com.team.backendjibi.shared.GeneratePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class BackendJibiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendJibiApplication.class, args);
    }

}
