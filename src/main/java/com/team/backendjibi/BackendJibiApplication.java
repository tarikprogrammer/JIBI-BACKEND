
package com.team.backendjibi;
import com.team.backendjibi.creancier.services.CreancierServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendJibiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendJibiApplication.class, args);


    }
    @Bean
    CommandLineRunner start(CreancierServices creancierServices){
        return args -> {
            creancierServices.createCreancier();
        };
 }



}
