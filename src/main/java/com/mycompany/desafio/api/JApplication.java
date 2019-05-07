package com.mycompany.desafio.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author eduardobonfa
 */
@SpringBootApplication
@EnableScheduling
public class JApplication {

    public static void main(String[] args) {
        SpringApplication.run(JApplication.class, args);
    }
}
