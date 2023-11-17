package com.rest.playbookrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;

@SpringBootApplication()
public class PlaybookRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaybookRestApplication.class, args);
    }

}
