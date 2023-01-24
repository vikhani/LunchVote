package com.vikhani.lunchvote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LunchVoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(LunchVoteApplication.class, args);
    }

}
