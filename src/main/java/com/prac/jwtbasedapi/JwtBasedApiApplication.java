package com.prac.jwtbasedapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JwtBasedApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtBasedApiApplication.class, args);
    }

}
